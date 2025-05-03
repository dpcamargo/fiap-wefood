package br.com.fiap.wefood.domain.entities;

public record User(
        Long id,
        String name,
        Email email,
        String username,
        Password password,
        String address) {
}
