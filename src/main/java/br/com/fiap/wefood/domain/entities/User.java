package br.com.fiap.wefood.domain.entities;

public record User(
        Id id,
        Name name,
        Email email,
        Username username,
        Password password,
        Address address
) {
}
