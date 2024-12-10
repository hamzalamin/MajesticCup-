package com.wora.majesticcup.models.DTOs.round;

import jakarta.validation.constraints.Positive;

import java.util.List;

public record UpdateRoundDto(
        @Positive Integer roundNumber,
        String competitionId,
        List<String> matches
) {
}