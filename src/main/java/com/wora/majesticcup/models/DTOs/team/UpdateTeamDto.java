package com.wora.majesticcup.models.DTOs.team;

import com.wora.majesticcup.models.DTOs.player.EmbeddedPlayerDto;

import java.util.List;

public record UpdateTeamDto(
        String name,
        String city,
        List<EmbeddedPlayerDto> players
) {
}
