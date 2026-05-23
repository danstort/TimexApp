package com.dso.timex.application.port.in;

import com.dso.timex.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {

    List<User> listUsers();

    Optional<User> getUserById(UUID id);

    User createUser(String email, String displayName);
}
