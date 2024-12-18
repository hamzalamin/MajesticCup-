package com.wora.majesticcup.models.DTOs.match;

import com.wora.majesticcup.models.DTOs.result.ResultDto;

public record CreateMatchDto(
        int round,
        String team1,
        String team2,
        ResultDto result
) {}
