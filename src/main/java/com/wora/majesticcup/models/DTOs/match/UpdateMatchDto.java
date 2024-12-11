package com.wora.majesticcup.models.DTOs.match;

import jakarta.validation.constraints.NotNull;

public record UpdateMatchDto(
        @NotNull Integer round,
        @NotNull String team1,
        @NotNull String team2
) {
}