package br.com.fiap.wefood.dto;

public record UserDtoRequest(
        String id,
        String name,
        String email,
        String username,
        String password,
        String role,
        AddressDto address
) {
}
