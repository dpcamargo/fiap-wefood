package br.com.fiap.wefood.mapper.impl;

import br.com.fiap.wefood.domain.entities.Address;
import br.com.fiap.wefood.domain.entities.Email;
import br.com.fiap.wefood.domain.entities.Id;
import br.com.fiap.wefood.domain.entities.Name;
import br.com.fiap.wefood.domain.entities.Password;
import br.com.fiap.wefood.domain.entities.User;
import br.com.fiap.wefood.domain.entities.Username;
import br.com.fiap.wefood.dto.UserDTO;
import br.com.fiap.wefood.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.id().value(),
                user.name().value(),
                user.email().value(),
                user.username().value(),
                user.password().value(),
                user.address().value()
        );
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return new User(
                new Id(userDTO.id()),
                new Name(userDTO.name()),
                new Email(userDTO.email()),
                new Username(userDTO.username()),
                new Password(userDTO.password()),
                new Address(userDTO.address())
                );
    }
}
