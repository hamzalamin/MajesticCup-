package com.wora.majesticcup.models.DTOs.player;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EmbeddedPlayerDto(
        @NotNull String id,
        @NotBlank String name,
        @NotBlank String surname,
        @NotBlank String position,
        @NotNull @Positive int number
) {
}