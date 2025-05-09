package br.com.fiap.wefood.mapper;

import br.com.fiap.wefood.domain.UserType;
import br.com.fiap.wefood.domain.model.Address;
import br.com.fiap.wefood.domain.model.Email;
import br.com.fiap.wefood.domain.model.Id;
import br.com.fiap.wefood.domain.model.Name;
import br.com.fiap.wefood.domain.model.Password;
import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.domain.model.Username;
import br.com.fiap.wefood.dto.UserDTO;
import br.com.fiap.wefood.repository.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User dtoToDomain(UserDTO userDTO);

    // Mapping domain to entity
    @Mapping(target = "id", expression = "java(idToLong(user.id()))")
    @Mapping(target = "name", expression = "java(nameToString(user.name()))")
    @Mapping(target = "email", expression = "java(emailToString(user.email()))")
    @Mapping(target = "username", expression = "java(usernameToString(user.username()))")
    @Mapping(target = "password", expression = "java(passwordToString(user.password()))")
    @Mapping(target = "address", expression = "java(addressToString(user.address()))")
    @Mapping(target = "type", expression = "java(userTypeToString(user.type()))")
    UserEntity toEntity(User user);

    // Mapping entity to domain
    @Mapping(target = "id", expression = "java(longToId(userEntity.getId()))")
    @Mapping(target = "name", expression = "java(stringToName(userEntity.getName()))")
    @Mapping(target = "email", expression = "java(stringToEmail(userEntity.getEmail()))")
    @Mapping(target = "username", expression = "java(stringToUsername(userEntity.getUsername()))")
    @Mapping(target = "password", expression = "java(stringToPassword(userEntity.getPassword()))")
    @Mapping(target = "address", expression = "java(stringToAddress(userEntity.getAddress()))")
    @Mapping(target = "type", expression = "java(stringToUserType(userEntity.getType()))")
    User entityToDomain(UserEntity userEntity);

    // ----- helpers ------
    // id
    default Long idToLong(Id id) { return id == null ? null : id.value(); }
    default Id longToId(Long value) { return value == null ? null : new Id(value); }

    // name
    default String nameToString(Name name) { return name == null ? null : name.value(); }
    default Name stringToName(String value) { return value == null ? null : new Name(value); }

    // email
    default String emailToString(Email email) { return email == null ? null : email.value(); }
    default Email stringToEmail(String value) { return value == null ? null : new Email(value); }

    // username
    default String usernameToString(Username username) { return username == null ? null : username.value(); }
    default Username stringToUsername(String value) { return value == null ? null : new Username(value); }

    // password
    default String passwordToString(Password password) { return password == null ? null : password.value(); }
    default Password stringToPassword(String value) { return value == null ? null : new Password(value); }

    // address
    default String addressToString(Address address) { return address == null ? null : address.value(); }
    default Address stringToAddress(String value) { return value == null ? null : new Address(value); }

    // type (if UserType is enum)
    default String userTypeToString(UserType type) { return type == null ? null : type.name(); }
    default UserType stringToUserType(String value) { return value == null ? null : UserType.valueOf(value); }
}