package br.com.fiap.wefood.domain.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    User update(User user);
    List<User> findAllUsers();
    Optional<User> findById(UUID id);
    Optional<User> findByUsername(String username);
    void delete(UUID id);
}
