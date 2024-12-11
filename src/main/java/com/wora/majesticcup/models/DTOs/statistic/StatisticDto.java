package com.wora.majesticcup.models.DTOs.statistic;

import com.wora.majesticcup.models.DTOs.result.EmbeddedResultDto;
import jakarta.validation.constraints.NotNull;

public record StatisticDto(
        @NotNull String id,
        @NotNull String playerId,
        @NotNull Integer goals,
        @NotNull Integer assists,
        @NotNull Integer yellowCards,
        @NotNull Integer redCards,
        EmbeddedResultDto result
) {
}