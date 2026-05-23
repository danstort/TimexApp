package com.dso.timex.application.port.out;

import com.dso.timex.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {

    List<User> findAll();

    Optional<User> findById(UUID id);

    User save(User user);
}
