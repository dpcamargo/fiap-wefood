package br.com.fiap.wefood;

import br.com.fiap.wefood.dto.UserDTO;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.repository.dao.mapper.UserDAOMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WefoodApplication {

    public static void main(String[] args) {

        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        UserDAOMapper userDAOMapper = Mappers.getMapper(UserDAOMapper.class);
        var userDTO = new UserDTO(1L, "name", "email@email.com", "username", "pas@12_Asword", "CUSTOMER", "address");
        var userDomain = userMapper.toDomain(userDTO);
        var dao = userDAOMapper.toDAO(userDomain);
        var backAgain = userDAOMapper.toDomain(dao);
        System.out.println(userDomain);
        System.out.println(dao);
        System.out.println(backAgain);
        System.exit(1);



        SpringApplication.run(WefoodApplication.class, args);
    }

}
