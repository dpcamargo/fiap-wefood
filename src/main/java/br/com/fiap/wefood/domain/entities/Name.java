package br.com.fiap.wefood.domain.entities;

import br.com.fiap.wefood.utils.NameValidator;

public record Name(String value) {

    public Name {
        if (!NameValidator.isValid(value)) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }
    }
}
