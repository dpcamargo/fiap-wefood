package br.com.fiap.wefood.domain.entities;

import br.com.fiap.wefood.domain.UserType;

public record User(
        Id id,
        Name name,
        Email email,
        Username username,
        Password password,
        UserType type,
        Address address
) {
}
