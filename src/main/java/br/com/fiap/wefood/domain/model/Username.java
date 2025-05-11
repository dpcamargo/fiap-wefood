package br.com.fiap.wefood.domain.model;

public record Username(String value) {
    public Username {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid username: " + value);
        }
    }

    private static boolean isValid(String value) {
        return value != null && value.matches("[A-Za-z0-9_]{3,30}");
    }
}
