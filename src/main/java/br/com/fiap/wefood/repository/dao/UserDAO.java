package br.com.fiap.wefood.repository.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "users")
public record UserDAO(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        String email,
        String username,
        String password,
        String type,
        String address,
        @Column(name = "created_at", updatable = false)
        @CreatedDate
        LocalDate createdAt,
        @Column(name = "updated_at")
        @LastModifiedDate
        LocalDate updatedAt
) {
}
