package com.wora.majesticcup.models.DTOs.competition;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EmbeddedCompetitionDto(
        @NotNull String id,
        @NotNull String name,
        @NotNull @Positive Integer numberOfTeams,
        @NotNull Integer currentRound
) {
}