package br.com.fiap.wefood.repository.user;

import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserEntityRepository jpaUserEntityRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(
            JpaUserEntityRepository jpaUserEntityRepository,
            UserMapper userMapper) {
        this.jpaUserEntityRepository = jpaUserEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedUser = jpaUserEntityRepository.save(userEntity);
        return userMapper.entityToDomain(savedUser);
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedUser = jpaUserEntityRepository.save(userEntity);
        return userMapper.entityToDomain(savedUser);
    }

    @Override
    public List<User> getUsers() {
        return jpaUserEntityRepository.findAll().stream().map(userMapper::entityToDomain).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserEntityRepository.findById(id).map(userMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserEntityRepository.findByUsername(username).map(userMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserEntityRepository.findByEmail(email).map(userMapper::entityToDomain);
    }

    @Override
    public void delete(Long id) {
        jpaUserEntityRepository.deleteById(id);
    }
}
