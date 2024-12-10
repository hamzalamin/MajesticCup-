package com.wora.majesticcup.models.DTOs.user;

import jakarta.validation.constraints.NotNull;

public record EmbeddedUserDto(
        @NotNull String id,
        @NotNull String username
) {
}