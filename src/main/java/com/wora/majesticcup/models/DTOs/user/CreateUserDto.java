package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(
        @NotBlank String username,
        @NotBlank String password,
        @NotNull Role roles
) {
}