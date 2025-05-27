package br.com.fiap.wefood.application.usecases;

import br.com.fiap.wefood.domain.user.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(String id);
    public Optional<User> getUserById(String id);
    public List<User> getUsers();
}
