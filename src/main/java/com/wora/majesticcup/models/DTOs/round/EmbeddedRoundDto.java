package com.wora.majesticcup.models.DTOs.round;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EmbeddedRoundDto(
        @NotNull String id,
        @NotNull @Positive Integer roundNumber,
        @NotNull String competitionId
) {
}