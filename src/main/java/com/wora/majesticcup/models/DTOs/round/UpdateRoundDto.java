package com.wora.majesticcup.models.DTOs.round;

import com.wora.majesticcup.models.DTOs.match.MatchDto;

import java.util.List;

public record UpdateRoundDto(
        int roundNumber,
        String competitionId,
        List<MatchDto> matches
) {}