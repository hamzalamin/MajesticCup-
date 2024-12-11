package com.wora.majesticcup.models.DTOs.round;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateRoundDto(
        @NotNull @Positive Integer roundNumber,
        @NotNull String competitionId
) {
}