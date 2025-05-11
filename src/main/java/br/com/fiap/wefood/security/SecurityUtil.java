package br.com.fiap.wefood.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityUtil {
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getCurrentUsername() {
        Authentication auth = getAuthentication();
        return auth != null ? auth.getName() : null;
    }

    public static String getJwtToken() {
        Authentication auth = getAuthentication();
        return auth != null ? auth.getCredentials().toString() : null;
    }
}
