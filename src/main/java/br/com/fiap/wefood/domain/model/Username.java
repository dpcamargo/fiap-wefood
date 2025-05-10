package br.com.fiap.wefood.domain.model;

import br.com.fiap.wefood.util.NameValidator;

public record Username(String value) {

    public Username {
        if (!NameValidator.isValid(value)) {
            throw new IllegalArgumentException("Username must be at least 3 characters long");
        }
    }
}
