package com.dso.timex.infrastructure.adapter.in.rest;

import com.dso.timex.application.port.in.UserUseCase;
import com.dso.timex.domain.model.User;
import com.dso.timex.infrastructure.adapter.in.rest.dto.CreateUserRequest;
import com.dso.timex.infrastructure.adapter.in.rest.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/public/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @GetMapping
    public List<UserResponse> listUsers() {
        return userUseCase.listUsers().stream().map(UserController::toResponse).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        return userUseCase.getUserById(id)
                .map(UserController::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        User createdUser = userUseCase.createUser(request.email(), request.displayName());
        UserResponse response = toResponse(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(URI.create("/api/public/users/" + response.id()))
                .body(response);
    }

    private static UserResponse toResponse(User user) {
        return new UserResponse(user.id(), user.email(), user.displayName(), user.createdAt());
    }
}
