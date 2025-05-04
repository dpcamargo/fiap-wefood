package br.com.fiap.wefood.dto;

import lombok.Getter;

public record UserDTO(Long id, String name, String email, String username, String password, String address) {
}
