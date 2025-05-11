package br.com.fiap.wefood.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDenied(AccessDeniedException ex, HttpServletRequest req) {
        ApiError error = new ApiError(
                403,
                "Forbidden",
                ex.getMessage().isEmpty() ? "You do not have permission to perform this action." : ex.getMessage(),
                req.getRequestURI()
        );
        log.warn("Access denied: {}", error);
        return ResponseEntity.status(403).body(error);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthentication(AuthenticationException ex, HttpServletRequest req) {
        ApiError error = new ApiError(
                401,
                "Unauthorized",
                ex.getMessage().isEmpty() ? "Full authentication is required to access this resource." : ex.getMessage(),
                req.getRequestURI()
        );
        log.info("Authentication failed: {}", error);
        return ResponseEntity.status(401).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex, HttpServletRequest req) {
        ApiError error = new ApiError(
                500,
                "Internal Server Error",
                ex.getMessage(),
                req.getRequestURI()
        );
        log.error("Unexpected error: {}", error);
        return ResponseEntity.status(500).body(error);
    }
}
