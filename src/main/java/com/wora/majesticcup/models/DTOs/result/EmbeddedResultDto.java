package com.wora.majesticcup.models.DTOs.result;

import jakarta.validation.constraints.NotNull;

public record EmbeddedResultDto(
        @NotNull String id,
        @NotNull Integer scoreTeam1,
        @NotNull Integer scoreTeam2
) {
}
