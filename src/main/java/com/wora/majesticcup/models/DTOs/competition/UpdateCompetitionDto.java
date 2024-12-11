package com.wora.majesticcup.models.DTOs.competition;

import jakarta.validation.constraints.Positive;

public record UpdateCompetitionDto(
        String name,
        @Positive Integer numberOfTeams,
        @Positive Integer currentRound
) {
}