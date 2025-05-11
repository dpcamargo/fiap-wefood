package br.com.fiap.wefood.controller;

import br.com.fiap.wefood.domain.model.User;
import br.com.fiap.wefood.dto.UserDtoRequest;
import br.com.fiap.wefood.dto.UserDtoResponse;
import br.com.fiap.wefood.exception.UserNotFoundException;
import br.com.fiap.wefood.mapper.UserMapper;
import br.com.fiap.wefood.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(
            UserService userService,
            UserMapper userMapper
    ) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Get all users. Administrators only.", description = "Returns a list of all users.")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDtoResponse>> getUsers() {
        List<User> users = userService.getUsers();
        List<UserDtoResponse> usersDtoResponse = users.stream()
                .map(userMapper::toDto)
                .toList();
        return ResponseEntity.ok().body(usersDtoResponse);
    }

    @Operation(summary = "Get user by ID. User can only get it's own data. Admin can get any user.", description = "Returns a user by their ID.")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @GetMapping("/{user_id}")
    public ResponseEntity<UserDtoResponse> getUser(@PathVariable("user_id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> ResponseEntity.ok().body(userMapper.toDto(value))).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Operation(summary = "Create a new user. Can only create CUSTOMER role. Admin can create any role.", description = "Creates a new user.")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserDtoRequest userDTORequest) {
        User user = userMapper.dtoToDomain(userDTORequest);
        User createdUser = userService.createUser(user);
        UserDtoResponse userDtoResponse = userMapper.toDto(createdUser);
        return ResponseEntity.status(201).body(userDtoResponse);
    }
}
