package br.com.fiap.wefood;

import br.com.fiap.wefood.dto.UserDTO;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WefoodApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WefoodApplication.class).registerShutdownHook(true).run(args);
    }
}
