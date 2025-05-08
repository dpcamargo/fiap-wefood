package br.com.fiap.wefood;

import br.com.fiap.wefood.dto.UserDTO;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WefoodApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(WefoodApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        var userDTO = new UserDTO(1L, "name", "email@email.com", "username", "pas@12_Asword", "CUSTOMER", "address");
        var userDomain = userMapper.dtoToDomain(userDTO);
        var entity = userMapper.toEntity(userDomain);
        var backAgain = userMapper.entityToDomain(entity);
        System.out.println(userDomain);
        System.out.println(entity);
        System.out.println(backAgain);

        var u = userRepository.save(userDomain);
        System.out.println(u);
    }
}
