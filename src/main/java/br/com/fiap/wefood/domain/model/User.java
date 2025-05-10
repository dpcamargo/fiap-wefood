package br.com.fiap.wefood.domain.model;

public record User(
        Id id,
        Name name,
        Email email,
        Username username,
        Password password,
        Role role,
        Address address
) {
}
