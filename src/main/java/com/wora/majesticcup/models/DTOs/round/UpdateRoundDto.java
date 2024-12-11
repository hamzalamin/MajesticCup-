package com.wora.majesticcup.models.DTOs.round;

import jakarta.validation.constraints.Positive;


public record UpdateRoundDto(
        @Positive Integer roundNumber,
        String competitionId
) {
}