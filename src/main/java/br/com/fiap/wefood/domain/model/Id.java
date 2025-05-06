package br.com.fiap.wefood.domain.model;

public record Id(Long value) {

    public Id {
        if (value < 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
    }
}
