package br.com.fiap.wefood.service;

import br.com.fiap.wefood.domain.model.Password;
import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.repository.UserRepository;
import java.util.List;
import java.util.Optional;
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
        User userToSave = new User(
                user.id(),
                user.name(),
                user.email(),
                user.username(),
                new Password(passwordEncoder.encode(user.password().value())),
                user.role(),
                user.address());
        return userRepository.save(userToSave);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

//    public String login(String password) {
//        return securityConfig.bCryptPasswordEncoder().encode(password);
//    }
}
