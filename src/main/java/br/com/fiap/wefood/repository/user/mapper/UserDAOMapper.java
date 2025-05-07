package br.com.fiap.wefood.repository.user.mapper;

import br.com.fiap.wefood.domain.model.Address;
import br.com.fiap.wefood.domain.model.Email;
import br.com.fiap.wefood.domain.model.Id;
import br.com.fiap.wefood.domain.model.Name;
import br.com.fiap.wefood.domain.model.Password;
import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.domain.model.Username;
import br.com.fiap.wefood.repository.user.UserDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDAOMapper {
    User toDomain(UserDAO user);
    UserDAO toDAO(User user);

    default Long idToLong(Id id) { return id == null ? null : id.value();}
    default Id longToId(Long value) { return value == null ? null : new Id(value); }

    default String nameToString(Name name) { return name == null ? null : name.value();}
    default Name stringToName(String value) { return value == null ? null : new Name(value);}

    default String emailToString(Email email) { return email == null ? null : email.value();}
    default Email stringToEmail(String value) { return value == null ? null : new Email(value);}

    default String usernameToString(Username username) { return username == null ? null : username.value();}
    default Username stringToUsername(String value) { return value == null ? null : new Username(value);}

    default String passwordToString(Password password) { return password == null ? null : password.value();}
    default Password stringToPassword(String value) { return value == null ? null : new Password(value);}

    default String addressToString(Address address) { return address == null ? null : address.value();}
    default Address stringToAddress(String value) { return value == null ? null : new Address(value);}
}
