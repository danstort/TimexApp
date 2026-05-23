package com.dso.timex.infrastructure.adapter.out.jpa;

import com.dso.timex.application.port.out.UserRepositoryPort;
import com.dso.timex.domain.model.User;
import com.dso.timex.infrastructure.adapter.out.jpa.entity.UserJpaEntity;
import com.dso.timex.infrastructure.adapter.out.jpa.repository.SpringDataUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository repository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"))
                .stream()
                .map(JpaUserRepositoryAdapter::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(JpaUserRepositoryAdapter::toDomain);
    }

    @Override
    public User save(User user) {
        UserJpaEntity saved = repository.save(toEntity(user));
        return toDomain(saved);
    }

    private static UserJpaEntity toEntity(User user) {
        return new UserJpaEntity(user.id(), user.email(), user.displayName(), user.createdAt());
    }

    private static User toDomain(UserJpaEntity entity) {
        return new User(entity.getId(), entity.getEmail(), entity.getDisplayName(), entity.getCreatedAt());
    }
}
