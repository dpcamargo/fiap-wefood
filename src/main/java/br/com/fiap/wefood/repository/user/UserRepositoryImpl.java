package br.com.fiap.wefood.repository.user;

import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.repository.UserRepository;
import br.com.fiap.wefood.repository.user.mapper.UserDAOMapper;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final JpaUserDAORepository jpaUserDAORepository;
    private final UserDAOMapper userDAOMapper;

    public UserRepositoryImpl(
            JpaUserDAORepository jpaUserDAORepository,
            UserDAOMapper userDAO) {
        this.jpaUserDAORepository = jpaUserDAORepository;
        this.userDAOMapper = userDAO;
    }

    @Override
    public User save(User user) {
        UserDAO userDAO = userDAOMapper.toDAO(user);
        UserDAO savedUser = jpaUserDAORepository.save(userDAO);
        return userDAOMapper.toDomain(savedUser);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserDAORepository.findById(id).map(userDAOMapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserDAORepository.findBy;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
