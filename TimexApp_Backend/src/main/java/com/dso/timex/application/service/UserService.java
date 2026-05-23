package com.dso.timex.application.service;

import com.dso.timex.application.port.in.UserUseCase;
import com.dso.timex.application.port.out.UserRepositoryPort;
import com.dso.timex.domain.model.User;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepository;
    private final Clock clock;

    public UserService(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
        this.clock = Clock.systemUTC();
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(String email, String displayName) {
        User user = new User(UUID.randomUUID(), email.trim(), displayName.trim(), Instant.now(clock));
        return userRepository.save(user);
    }
}
