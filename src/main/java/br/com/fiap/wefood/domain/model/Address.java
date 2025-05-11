package br.com.fiap.wefood.domain.model;


public record Address(String value) {
    public Address {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid address: " + value);
        }
    }

    private static boolean isValid(String value) {
        return value != null && value.length() >= 3;
    }
}