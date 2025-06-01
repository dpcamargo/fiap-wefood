package br.com.fiap.wefood.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record UserDtoResponse(
        String id,
        String name,
        String email,
        String username,
        String role,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime lastUpdateDate,
        @JsonProperty("address")
        AddressDto adress
) {
}
