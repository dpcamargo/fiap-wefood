package br.com.fiap.wefood.domain.model;

public record Id(Long value) {

    public Id {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
    }

    private static boolean isValid(Long value) {
        return value > 0;
    }
}

