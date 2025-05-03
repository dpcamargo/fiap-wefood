package br.com.fiap.wefood.domain.entities;

import java.util.regex.Pattern;

public record Email(String value) {
    static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public Email {
        if (!isValidEmail(value)) {
            throw new IllegalArgumentException(String.format("Invalid email format: %s", value));
        }
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
}
