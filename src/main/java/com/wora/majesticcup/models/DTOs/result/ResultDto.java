package com.wora.majesticcup.models.DTOs.result;

import com.wora.majesticcup.models.DTOs.statistic.EmbeddedStatisticDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ResultDto(
        @NotNull String id,
        @NotNull Integer scoreTeam1,
        @NotNull Integer scoreTeam2,
        @NotBlank String matchId,
        List<EmbeddedStatisticDto> statistic
) {
}