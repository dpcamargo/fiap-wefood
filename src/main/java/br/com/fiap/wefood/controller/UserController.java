package br.com.fiap.wefood.controller;

import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.dto.UserDTO;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> user = userService.getUsers();
        List<UserDTO> userDTOs = user.stream()
                .map(userMapper::toDTO)
                .toList();
        return ResponseEntity.ok().body(userDTOs);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.dtoToDomain(userDTO);
        User createdUser = userService.createUser(user);
        UserDTO createdUserDTO = userMapper.toDTO(createdUser);
        return ResponseEntity.status(201).body(createdUserDTO);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("user_id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> ResponseEntity.ok().body(userMapper.toDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
