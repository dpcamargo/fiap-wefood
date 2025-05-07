package br.com.fiap.wefood.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserDAORepository extends JpaRepository<UserDAO, Long> {
}
