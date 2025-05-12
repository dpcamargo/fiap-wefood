package br.com.fiap.wefood.service;

import br.com.fiap.wefood.domain.model.Password;
import br.com.fiap.wefood.domain.model.Role;
import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.repository.UserRepository;
import br.com.fiap.wefood.security.SecurityUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        boolean isAdmin = SecurityUtil.isAdmin();
        boolean isCustomer = user.role().equals(Role.CUSTOMER);

        if (!(isCustomer || isAdmin)) {
            throw new AccessDeniedException(null);
        }

        User userToSave = new User(
                user.id(),
                user.name(),
                user.email(),
                user.username(),
                Password.ofHash(passwordEncoder.encode(user.password().value())),
                user.role(),
                user.address());
        return userRepository.save(userToSave);
    }

    public User updateUser(User user) {
        boolean notSameUser = !user.id().value().equals(SecurityUtil.getUserId());
        boolean notAdmin = !SecurityUtil.isAdmin();
        boolean notCustomer = !user.role().equals(Role.CUSTOMER);

        if ((notSameUser && notAdmin) || (notCustomer && notAdmin)) {
            throw new AccessDeniedException(null);
        }

        User userToUpdate = new User(
                user.id(),
                user.name(),
                user.email(),
                user.username(),
                Password.ofHash(passwordEncoder.encode(user.password().value())),
                user.role(),
                user.address());
        return userRepository.update(userToUpdate);
    }

    public void deleteUser(Long id) {
        boolean notSameUser = !id.equals(SecurityUtil.getUserId());
        boolean notAdmin = !SecurityUtil.isAdmin();

        if (notSameUser && notAdmin) {
            throw new AccessDeniedException(null);
        }
        userRepository.delete(id);
    }

    public Optional<User> getUserById(Long id) {
        if (!id.equals(SecurityUtil.getUserId()) && !SecurityUtil.isAdmin()) {
            throw new AccessDeniedException(null);
        }
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();

        return userRepository.getUsers();
    }
}
