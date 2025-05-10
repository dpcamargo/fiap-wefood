package br.com.fiap.wefood.util;

public class NameValidator {
    private NameValidator() {}

    public static boolean isValid(String name) {
        return name.length() >=3;
    }
}
