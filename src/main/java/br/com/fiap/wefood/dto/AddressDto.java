package br.com.fiap.wefood.dto;

public record AddressDto(
        String street,
        String neighborhood,
        String zipcode,
        String city,
        String state
) {}

