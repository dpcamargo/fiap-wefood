package br.com.fiap.wefood.adapters.outbound.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="address")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaAddressEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;

    @OneToOne
    @JoinColumn(name="user_id")
    private JpaUserEntity user;
}