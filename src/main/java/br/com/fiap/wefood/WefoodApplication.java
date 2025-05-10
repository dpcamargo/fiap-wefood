package br.com.fiap.wefood;

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
