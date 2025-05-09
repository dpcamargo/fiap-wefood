package br.com.fiap.wefood.dto;

public record UserDTO(
        Long id,
        String name,
        String email,
        String username,
        String password,
        String type,
        String address
) {
}
