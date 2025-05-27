package br.com.fiap.wefood.application.service;

import br.com.fiap.wefood.adapters.outbound.password.PasswordEncoder;
import br.com.fiap.wefood.application.usecases.UserUseCase;
import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.domain.user.UserRepository;
import br.com.fiap.wefood.security.SecurityUtil;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        boolean isAdmin = SecurityUtil.isAdmin();
        boolean isCustomer = user.getRole().equals(Role.CUSTOMER);

        if (!(isCustomer || isAdmin)) {
            throw new AccessDeniedException(null);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        boolean notSameUser = !user.getId().equals(SecurityUtil.getUserId());
        boolean notAdmin = !SecurityUtil.isAdmin();
        boolean notCustomer = !user.getRole().equals(Role.CUSTOMER);

        if ((notSameUser && notAdmin) || (notCustomer && notAdmin)) {
            throw new AccessDeniedException(null);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.update(user);
    }

    public void deleteUser(String id) {
        UUID uuid = UUID.fromString(id);
        boolean notSameUser = !uuid.equals(SecurityUtil.getUserId());
        boolean notAdmin = !SecurityUtil.isAdmin();

        if (notSameUser && notAdmin) {
            throw new AccessDeniedException(null);
        }
        userRepository.delete(uuid);
    }

    public Optional<User> getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        if (!uuid.equals(SecurityUtil.getUserId()) && !SecurityUtil.isAdmin()) {
            throw new AccessDeniedException(null);
        }
        return userRepository.findById(uuid);
    }

    public List<User> getUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();

        return userRepository.findAllUsers();
    }
}
