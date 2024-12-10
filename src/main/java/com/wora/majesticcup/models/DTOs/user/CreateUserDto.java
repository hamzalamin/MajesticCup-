package com.wora.majesticcup.models.DTOs.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateUserDto(
        @NotBlank String username,
        @NotBlank String password,
        @NotNull List<String> roles
) {
}