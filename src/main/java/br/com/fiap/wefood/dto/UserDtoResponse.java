package br.com.fiap.wefood.dto;

public record UserDtoResponse(
        Long id,
        String name,
        String email,
        String username,
        String role,
        String address
) {
}
