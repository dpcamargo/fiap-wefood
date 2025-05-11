package br.com.fiap.wefood.domain.model;

public record Name(String value) {
    public Name {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid name: " + value);
        }
    }

    private static boolean isValid(String value) {
        return value != null && value.matches("[A-Za-z0-9_]{3,30}");
    }
}
