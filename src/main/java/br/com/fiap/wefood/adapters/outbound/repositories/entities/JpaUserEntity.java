package br.com.fiap.wefood.adapters.outbound.repositories.entities;

import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaUserEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;
    private Role role;

    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    @Column(length = 255)
    private String address;


    public JpaUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.lastUpdateDate = user.getLastUpdateDate();
        this.address = String.format(
                "%s, %s, %s - %s, %s",
                user.getStreet(),
                user.getNeighborhood(),
                user.getCity(),
                user.getState(),
                user.getZipCode()
        );
    }

}
