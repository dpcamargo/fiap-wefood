package br.com.fiap.wefood.mapper;

import br.com.fiap.wefood.domain.model.Address;
import br.com.fiap.wefood.domain.model.Email;
import br.com.fiap.wefood.domain.model.Id;
import br.com.fiap.wefood.domain.model.Name;
import br.com.fiap.wefood.domain.model.Password;
import br.com.fiap.wefood.domain.model.Role;
import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.domain.model.Username;
import br.com.fiap.wefood.dto.UserDtoRequest;
import br.com.fiap.wefood.dto.UserDtoResponse;
import br.com.fiap.wefood.repository.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDtoResponse toDto(User user);
    // For DTO to domain, use Password.ofRaw
    @Mapping(target = "password", source = "password", qualifiedByName = "stringToPasswordRaw")
    User dtoToDomain(UserDtoRequest userDtoRequest);

    // Mapping domain to entity
    @Mapping(target = "id", expression = "java(idToLong(user.id()))")
    @Mapping(target = "name", expression = "java(nameToString(user.name()))")
    @Mapping(target = "email", expression = "java(emailToString(user.email()))")
    @Mapping(target = "username", expression = "java(usernameToString(user.username()))")
    @Mapping(target = "password", expression = "java(passwordToString(user.password()))")
    @Mapping(target = "address", expression = "java(addressToString(user.address()))")
    @Mapping(target = "role", expression = "java(userRoleToString(user.role()))")
    UserEntity toEntity(User user);

    // Mapping entity to domain (password hash from db)
    @Mapping(target = "id", expression = "java(longToId(userEntity.getId()))")
    @Mapping(target = "name", expression = "java(stringToName(userEntity.getName()))")
    @Mapping(target = "email", expression = "java(stringToEmail(userEntity.getEmail()))")
    @Mapping(target = "username", expression = "java(stringToUsername(userEntity.getUsername()))")
    @Mapping(target = "password", source = "password", qualifiedByName = "stringToPasswordHash")
    @Mapping(target = "address", expression = "java(stringToAddress(userEntity.getAddress()))")
    @Mapping(target = "role", expression = "java(stringToUserRole(userEntity.getRole()))")
    User entityToDomain(UserEntity userEntity);

    default Long idToLong(Id id) { return id == null ? null : id.value(); }
    default Id longToId(Long value) { return value == null ? null : new Id(value); }

    default String nameToString(Name name) { return name == null ? null : name.value(); }
    default Name stringToName(String value) { return value == null ? null : new Name(value); }

    default String emailToString(Email email) { return email == null ? null : email.value(); }
    default Email stringToEmail(String value) { return value == null ? null : new Email(value); }

    default String usernameToString(Username username) { return username == null ? null : username.value(); }
    default Username stringToUsername(String value) { return value == null ? null : new Username(value); }

    default String passwordToString(Password password) { return password == null ? null : password.value(); }

    @Named("stringToPasswordRaw")
    default Password stringToPasswordRaw(String value) { return value == null ? null : Password.ofRaw(value); }

    @Named("stringToPasswordHash")
    default Password stringToPasswordHash(String value) { return value == null ? null : Password.ofHash(value); }

    default String addressToString(Address address) { return address == null ? null : address.value(); }
    default Address stringToAddress(String value) { return value == null ? null : new Address(value); }

    default String userRoleToString(Role role) { return role == null ? null : role.name(); }
    default Role stringToUserRole(String value) { return value == null ? null : Role.valueOf(value.toUpperCase()); }
}