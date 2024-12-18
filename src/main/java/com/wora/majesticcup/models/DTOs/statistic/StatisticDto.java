package com.wora.majesticcup.models.DTOs.statistic;

public record StatisticDto(
        String playerId,
        int goals,
        int assists,
        int yellowCards,
        int redCards
) {
}