package br.com.fiap.wefood.dto;

import java.util.UUID;

public record UserDtoResponse(
        String id,
        String name,
        String email,
        String username,
        String role,
        String address
) {
}
