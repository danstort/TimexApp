package com.dso.timex.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "email is required")
        @Email(message = "email must be valid")
        String email,

        @NotBlank(message = "displayName is required")
        @Size(min = 2, max = 80, message = "displayName length must be between 2 and 80")
        String displayName
) {
}
