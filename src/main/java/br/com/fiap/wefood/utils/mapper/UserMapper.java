package br.com.fiap.wefood.utils.mapper;

import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaUserEntity;
import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.dto.UserDtoRequest;
import br.com.fiap.wefood.dto.UserDtoResponse;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User entityToDomain(JpaUserEntity user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    public static JpaUserEntity domainToEntity(User user) {
        return new JpaUserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    public static UserDtoResponse domainToDto(User user) {
        return new UserDtoResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getRole().toString(),
                "");
    }

    public static User dtoToDomain(UserDtoRequest userDto) {
        return new User(
                UUID.fromString(userDto.id()),
                userDto.name(),
                userDto.email(),
                userDto.username(),
                userDto.password(),
                Role.valueOf(userDto.role())
        );
    }
}
