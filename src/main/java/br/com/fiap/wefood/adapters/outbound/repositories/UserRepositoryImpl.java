package br.com.fiap.wefood.adapters.outbound.repositories;

import br.com.fiap.wefood.adapters.outbound.repositories.entities.JpaUserEntity;
import br.com.fiap.wefood.domain.user.User;
import br.com.fiap.wefood.domain.user.UserRepository;
import br.com.fiap.wefood.utils.mapper.UserMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(
            JpaUserRepository jpaUserRepository
    ) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        JpaUserEntity userEntity = new JpaUserEntity(user);
        JpaUserEntity savedUser = jpaUserRepository.save(userEntity);
        return UserMapper.entityToDomain(savedUser);
    }

    @Override
    public User update(User user) {
        JpaUserEntity userEntity = new JpaUserEntity(user);
        JpaUserEntity savedUser = jpaUserRepository.save(userEntity);
        return UserMapper.entityToDomain(savedUser);
    }

    @Override
    public List<User> findAllUsers() {
        return jpaUserRepository.findAll().stream().map(UserMapper::entityToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id).map(UserMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByUsername(username).map(UserMapper::entityToDomain);
    }

    @Override
    public void delete(UUID id) {
        jpaUserRepository.deleteById(id);
    }
}
