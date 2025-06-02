package br.com.fiap.wefood.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDtoResponse(
        String id,
        String name,
        String email,
        String username,
        String role,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        AddressDto address
) {
}
