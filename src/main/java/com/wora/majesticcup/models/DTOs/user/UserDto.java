package com.wora.majesticcup.models.DTOs.user;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserDto(
        @NotNull String id,
        @NotNull String username,
        @NotNull List<String> roles
) {
}