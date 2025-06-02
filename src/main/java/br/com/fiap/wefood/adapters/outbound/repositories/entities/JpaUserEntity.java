package br.com.fiap.wefood.adapters.outbound.repositories.entities;

import br.com.fiap.wefood.domain.user.Role;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.utils.mapper.AddressMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import jakarta.persistence.CascadeType;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = boolean.class))
@Filter(name = "deletedFilter", condition = "is_deleted = :isDeleted")
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

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name= "is_deleted")
    private boolean isDeleted;
    private LocalDateTime deletedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private JpaAddressEntity address;

    public JpaUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.isDeleted = false;
        this.address = AddressMapper.domainToEntity(user.getAddress(), this);
    }
}