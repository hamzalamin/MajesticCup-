package com.wora.majesticcup.models.DTOs.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmbeddedTeamDto(
        @NotNull String id,
        @NotBlank String name,
        @NotBlank String city
) {
}