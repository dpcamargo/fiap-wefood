//package br.com.fiap.wefood.repository.user;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EntityListeners;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import java.time.Instant;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//@Entity
//@Table(name = "users")
//@Data
//@NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
//public class UserEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private String email;
//    private String username;
//    private String password;
//    private String type;
//    private String address;
//    @Column(name = "created_at", updatable = false)
//    @CreatedDate
//    private Instant createdAt;
//    @Column(name = "updated_at")
//    @LastModifiedDate
//    private Instant updatedAt;
//}


package br.com.fiap.wefood.repository.user;

import jakarta.persistence.*;
        import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String type;
    private String address;
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private Instant createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    public UserEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}