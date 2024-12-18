package com.wora.majesticcup.models.DTOs.competition;

import java.util.List;

public record UpdateCompetitionDto(
        String name,
        int numberOfTeams,
        List<String> teams,
        int currentRound,
        List<String> rounds
) {}