package br.com.fiap.wefood.adapters.outbound.password;

public interface PasswordEncoder {
    String encode(CharSequence password);
}
