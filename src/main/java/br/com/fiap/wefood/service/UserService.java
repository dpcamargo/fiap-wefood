package br.com.fiap.wefood.service;

import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapper) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        userRepository.save(user);

    }
}
