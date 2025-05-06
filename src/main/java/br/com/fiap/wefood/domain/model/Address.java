package br.com.fiap.wefood.domain.model;

import br.com.fiap.wefood.utils.NameValidator;

public record Address(String value) {

    public Address {

        // TODO: CREATE ADDR VALIDATOR
        if (!NameValidator.isValid(value)) {
            throw new IllegalArgumentException("Address must be at least 3 characters long");
        }
    }
}
