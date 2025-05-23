package br.com.fiap.wefood.domain.model;

public record Name(String value) {
    public Name {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid name: " + value);
        }
    }

    private static boolean isValid(String value) {
        return value != null && value.length() >= 3;
    }
}
