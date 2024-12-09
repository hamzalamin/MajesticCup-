package com.wora.majesticcup.models.DTOs.competition;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateCompetitionDto(
        @NotNull String name,
        @NotNull @Positive Integer numberOfTeams,
        @NotNull List<String> teams,
        @NotNull Integer currentRound,
        @NotNull List<String> rounds
) {
}