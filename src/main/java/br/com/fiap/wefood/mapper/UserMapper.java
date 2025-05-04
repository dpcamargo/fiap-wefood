package br.com.fiap.wefood.mapper;

import br.com.fiap.wefood.domain.entities.User;
import br.com.fiap.wefood.dto.UserDTO;

public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
