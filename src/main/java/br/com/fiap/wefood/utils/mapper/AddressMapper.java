package br.com.fiap.wefood.utils.mapper;

import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaAddressEntity;
import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaUserEntity;
import br.com.fiap.wefood.domain.user.Address;
import br.com.fiap.wefood.dto.AddressDto;
import java.util.UUID;

public class AddressMapper {
    public static AddressDto domainToDto(Address address) {
        return new AddressDto(
                address.getId().toString(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getCity(),
                address.getState()
        );
    }

    public static Address dtoToDomain(AddressDto addressDto) {
        return new Address(
                addressDto.id() == null ? null : UUID.fromString(addressDto.id()),
                addressDto.street(),
                addressDto.number(),
                addressDto.complement(),
                addressDto.city(),
                addressDto.state()
        );
    }

    public static Address entityToDomain(JpaAddressEntity addressEntity) {
        return new Address(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getComplement(),
                addressEntity.getCity(),
                addressEntity.getState()
        );
    }

    public static JpaAddressEntity domainToEntity(Address address, JpaUserEntity userEntity) {
        if (address == null) return null;
        JpaAddressEntity entity = new JpaAddressEntity();
        entity.setStreet(address.getStreet());
        entity.setNumber(address.getNumber());
        entity.setComplement(address.getComplement());
        entity.setCity(address.getCity());
        entity.setState(address.getState());
        entity.setUser(userEntity); // <-- THIS IS VITAL
        return entity;
    }
}
