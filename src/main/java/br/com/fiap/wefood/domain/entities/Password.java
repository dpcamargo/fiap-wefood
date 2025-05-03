package br.com.fiap.wefood.domain.entities;

public record Password(String value) {
    public Password {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }

        if (value.length() < 8) {
            throw new IllegalArgumentException("password must be at least 8 characters long");
        }

    }
}
