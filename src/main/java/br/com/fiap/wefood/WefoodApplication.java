package br.com.fiap.wefood;

import br.com.fiap.wefood.domain.entities.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WefoodApplication {

	public static void main(String[] args) {

        Email email1 = new Email("jo@uol.com.br");
        Email email2 = new Email("jouol.com.br");
        Email email3 = new Email("jo@@@uol.com.br");
		SpringApplication.run(WefoodApplication.class, args);
	}

}
