package br.com.fiap.wefood.controller;

import br.com.fiap.wefood.security.JwtUtil;
import java.util.Date;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(
            JwtUtil jwtUtil,
            AuthenticationManager authenticationManager
    ) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        String token = jwtUtil.generateToken(authentication.getName());
        Date expiresAt = jwtUtil.extractExpirationDateFromToken(token);
        return new LoginResponse(token, authentication.getName(), expiresAt.toString());
    }

    public record LoginRequestDTO (
            String username,
            String password) {}

    public record LoginResponse(
            String token,
            String username,
            String expiresAt
    ) {}
}
