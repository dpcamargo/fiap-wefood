package br.com.fiap.wefood.dto;

import lombok.Builder;

@Builder
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
