package com.wora.majesticcup.models.DTOs.team;

import com.wora.majesticcup.models.DTOs.player.EmbeddedPlayerDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateTeamDto(
        @NotBlank String name,
        @NotBlank String city,
        @NotNull List<EmbeddedPlayerDto> players
) {
}