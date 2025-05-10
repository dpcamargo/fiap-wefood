package br.com.fiap.wefood.dto;

public record UserDtoRequest(
        String name,
        String email,
        String username,
        String password,
        String role,
        String address
) {
}
