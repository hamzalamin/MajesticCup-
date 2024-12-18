package com.wora.majesticcup.models.DTOs.competition;

import java.util.List;

public record CreateCompetitionDto(
        String name,
        int numberOfTeams,
        List<String> teams
) {}