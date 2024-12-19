package com.wora.majesticcup.models.DTOs.user;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordDto(
        @NotBlank String oldPassword,
        @NotBlank String newPassword
) {
}