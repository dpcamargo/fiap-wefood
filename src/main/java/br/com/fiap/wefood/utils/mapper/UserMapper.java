package br.com.fiap.wefood.utils.mapper;

import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaUserEntity;
import br.com.fiap.wefood.domain.user.Address;
import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.dto.AddressDto;
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
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getAddress() != null ? AddressMapper.entityToDomain(user.getAddress()) : null
        );
    }


    // TODO: UNNECESSARY?
    public static JpaUserEntity domainToEntity(User user) {
        return new JpaUserEntity(user);
    }

    public static UserDtoResponse domainToDto(User user) {
        return new UserDtoResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getRole().toString(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                AddressMapper.domainToDto(user.getAddress())
                );
    }

    public static User dtoToDomain(UserDtoRequest userDto) {
        return new User(
                userDto.id() == null ? null : UUID.fromString(userDto.id()),
                userDto.name(),
                userDto.email(),
                userDto.username(),
                userDto.password(),
                Role.valueOf(userDto.role()),
                AddressMapper.dtoToDomain(userDto.address())
        );
    }

    public static Address dtoToDomain(AddressDto addressDto) {
        return new Address(
                null,
                addressDto.street(),
                addressDto.number(),
                addressDto.complement(),
                addressDto.city(),
                addressDto.state()
        );
    }
}
