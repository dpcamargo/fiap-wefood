package br.com.fiap.wefood.adapters.outbound.password;

import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncoderEncoderAdapter implements PasswordEncoder {

    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    public BcryptPasswordEncoderEncoderAdapter(org.springframework.security.crypto.password.PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(CharSequence password) {
        return passwordEncoder.encode(password);
    }
}
