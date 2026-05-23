package com.dso.timex.infrastructure.adapter.in.rest.dto;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(UUID id, String email, String displayName, Instant createdAt) {
}
