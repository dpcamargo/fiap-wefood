package br.com.fiap.wefood.dto;

import java.util.UUID;

public record AddressDto(
        String id,
        String street,
        String number,
        String complement,
        String city,
        String state
) {
}