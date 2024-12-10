package com.wora.majesticcup.models.DTOs.competition;

import jakarta.validation.constraints.Positive;

import java.util.List;

public record UpdateCompetitionDto(
        String name,
        @Positive Integer numberOfTeams,
        List<String> teams,
        @Positive Integer currentRound,
        List<String> rounds
) {
}