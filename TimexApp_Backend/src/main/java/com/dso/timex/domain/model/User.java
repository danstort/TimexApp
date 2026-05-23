package com.dso.timex.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String email;
    private final String displayName;
    private final Instant createdAt;

    public User(UUID id, String email, String displayName, Instant createdAt) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.email = Objects.requireNonNull(email, "email is required");
        this.displayName = Objects.requireNonNull(displayName, "displayName is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
    }

    public UUID id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String displayName() {
        return displayName;
    }

    public Instant createdAt() {
        return createdAt;
    }
}
