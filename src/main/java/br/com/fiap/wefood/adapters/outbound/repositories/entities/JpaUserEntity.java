package br.com.fiap.wefood.adapters.outbound.repositories.entities;

import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaUserEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
    private String username;
    private String password;
    private Role role;

    public JpaUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}