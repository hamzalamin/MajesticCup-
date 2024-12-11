package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(
        String username,
        String password,
        @NotNull Role roles
) {
}