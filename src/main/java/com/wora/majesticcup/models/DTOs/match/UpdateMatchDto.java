package com.wora.majesticcup.models.DTOs.match;

import com.wora.majesticcup.models.DTOs.result.EmbeddedResultDto;
import jakarta.validation.constraints.NotNull;

public record UpdateMatchDto(
        @NotNull Integer round,
        @NotNull String team1,
        @NotNull String team2,
        @NotNull EmbeddedResultDto result
) {
}