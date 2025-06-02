package br.com.fiap.wefood.infrastructure.config;

import br.com.fiap.wefood.adapters.outbound.password.PasswordEncoder;
import br.com.fiap.wefood.domain.user.Address;
import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.domain.user.UserRepository;
import jakarta.annotation.PostConstruct;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminUserInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.password}")
    private String adminPassword;

    public AdminUserInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
            ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("admin").isEmpty()) {

            User adminUser = new User(
                    null,
                    "Administrator",
                    "admin@admin.com",
                    "admin",
                    passwordEncoder.encode(adminPassword),
                    Role.ADMIN,
                    new Address(
                            UUID.randomUUID(),
                            "Baker Street",
                            "1337",
                            "nil",
                            "London",
                            "GL"

                    )
            );

            userRepository.save(adminUser);
            log.info("admin user created.");
        }
    }
}
