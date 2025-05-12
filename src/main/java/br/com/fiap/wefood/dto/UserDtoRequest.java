package br.com.fiap.wefood.dto;

public record UserDtoRequest(
        Long id,
        String name,
        String email,
        String username,
        String password,
        String role,
        String address
) {
}
