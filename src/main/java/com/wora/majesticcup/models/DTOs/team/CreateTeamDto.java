package com.wora.majesticcup.models.DTOs.team;

import com.wora.majesticcup.models.DTOs.player.PlayerDto;

import java.util.List;

public record CreateTeamDto(
        String name,
        String city,
        List<PlayerDto> players
) {}