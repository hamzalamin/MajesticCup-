package com.wora.majesticcup.models.DTOs.result;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateResultDto(
        @NotNull Integer scoreTeam1,
        @NotNull Integer scoreTeam2,
        @NotBlank String matchId
) {
}