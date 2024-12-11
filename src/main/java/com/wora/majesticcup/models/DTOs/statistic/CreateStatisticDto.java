package com.wora.majesticcup.models.DTOs.statistic;


import jakarta.validation.constraints.NotNull;

public record CreateStatisticDto(
        @NotNull String playerId,
        @NotNull Integer goals,
        @NotNull Integer assists,
        @NotNull Integer yellowCards,
        @NotNull Integer redCards,
        @NotNull String result
) {
}