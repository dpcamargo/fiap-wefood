package br.com.fiap.wefood.adapters.outbound.repositories;

import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaUserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID>, PagingAndSortingRepository<JpaUserEntity, UUID> {
    Optional<JpaUserEntity> findByUsername(String username);
    Optional<JpaUserEntity> findByEmail(String email);
}
