package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;
import jakarta.validation.constraints.NotNull;

public record EmbeddedUserDto(
        @NotNull String id,
        @NotNull String username,
        @NotNull Role roles

) {
}