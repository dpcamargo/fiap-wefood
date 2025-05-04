package br.com.fiap.wefood.domain.entities;

import java.util.regex.Pattern;

public record Password(String value) {
    static String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])[^\\s]{8,16}$";

    public Password {
        if (!isValidPassword(value)) {
            throw new IllegalArgumentException(
                    """
                    Invalid password:
                    Must contain 1 number (0-9)
                    Must contain 1 uppercase letters
                    Must contain 1 lowercase letters
                    Must contain 1 non-alpha numeric number
                    Must be 8-16 characters with no spaces
                    """);
        }
    }

    private boolean isValidPassword(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
}
