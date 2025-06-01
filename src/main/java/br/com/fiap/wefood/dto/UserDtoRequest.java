package br.com.fiap.wefood.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserDtoRequest(
        String id,
        String name,
        String email,
        String username,
        String password,
        String role,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime lastUpdateDate,
        AddressDto address
) {
}
