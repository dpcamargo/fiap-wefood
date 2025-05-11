package br.com.fiap.wefood.config;

import br.com.fiap.wefood.domain.model.Address;
import br.com.fiap.wefood.domain.model.Email;
import br.com.fiap.wefood.domain.model.Name;
import br.com.fiap.wefood.domain.model.Password;
import br.com.fiap.wefood.domain.model.Role;
import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.domain.model.Username;
import br.com.fiap.wefood.dto.UserDtoRequest;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminUserInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Value("${admin.password}")
    private String adminPassword;

    public AdminUserInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            UserMapper userMapper
            ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("admin").isEmpty()) {

            User adminUser = new User(
                    null,
                    new Name("Administrator"),
                    new Email("admin@admin.com"),
                    new Username("admin"),
                    Password.ofHash(passwordEncoder.encode(adminPassword)),
                    Role.ADMIN,
                    new Address("221B Baker Street)")
            );
            userRepository.save(adminUser);
            log.info("admin user created.");
        }
    }
}
