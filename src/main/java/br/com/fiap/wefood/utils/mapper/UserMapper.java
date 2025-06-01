package br.com.fiap.wefood.utils.mapper;

import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaUserEntity;
import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.dto.AddressDto;
import br.com.fiap.wefood.dto.UserDtoRequest;
import br.com.fiap.wefood.dto.UserDtoResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public static User entityToDomain(JpaUserEntity userEntity) {
        String address = userEntity.getAddress(); // Ex: "Rua Exemplo, Centro, São Paulo - SP, 12345-678"

        // Valores padrão para evitar NullPointerException
        String street = "", neighborhood = "", city = "", state = "", zipCode = "";

        if (address != null && !address.isEmpty()) {
            try {
                String[] parts = address.split(", ");
                street = parts[0];
                neighborhood = parts[1];
                String[] cityState = parts[2].split(" - ");
                city = cityState[0];
                state = cityState[1];
                zipCode = parts[3];
            } catch (Exception e) {
                // log.warn("Erro ao fazer parse do endereço: " + address);
            }
        }

        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getLastUpdateDate(),
                street,
                neighborhood,
                zipCode,
                city,
                state
        );
    }

    public static JpaUserEntity domainToEntity(User user) {
        String address = String.format(
                "%s, %s, %s - %s, %s",
                safeString(user.getStreet()),
                safeString(user.getNeighborhood()),
                safeString(user.getCity()),
                safeString(user.getState()),
                safeString(user.getZipCode())
        );

        return new JpaUserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getLastUpdateDate(),
                address
        );
    }

    private static String safeString(String str) {
        return str == null ? "" : str.trim();
    }

    public static UserDtoResponse domainToDto(User user) {
        AddressDto address = new AddressDto(
                user.getStreet(),
                user.getNeighborhood(),
                user.getZipCode(),
                user.getCity(),
                user.getState()
        );

        return new UserDtoResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getRole().toString(),
                user.getLastUpdateDate(),
                address
        );
    }

    public static User dtoToDomain(UserDtoRequest userDto) {
        AddressDto addr = userDto.address();

        return new User(
                userDto.id() == null ? null : UUID.fromString(userDto.id()),
                userDto.name(),
                userDto.email(),
                userDto.username(),
                userDto.password(),
                Role.valueOf(userDto.role()),
                userDto.lastUpdateDate(),
                addr.street(),
                addr.neighborhood(),
                addr.zipcode(),
                addr.city(),
                addr.state()
        );
    }

}

