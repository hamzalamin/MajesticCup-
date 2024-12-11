package com.wora.majesticcup.models.DTOs.match;

import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import jakarta.validation.constraints.NotNull;

public record CreateMatchDto(
        @NotNull Integer round,
        @NotNull String team1,
        @NotNull String team2
) {
}