package br.com.fiap.wefood.repository;

import br.com.fiap.wefood.repository.dao.UserDAO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDAO, Long> {
    Optional<UserDAO> findByUsername(String username);
    Optional<UserDAO> findByEmail(String email);
    Boolean remove(Long id);
}
