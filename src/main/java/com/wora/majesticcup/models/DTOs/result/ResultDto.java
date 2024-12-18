package com.wora.majesticcup.models.DTOs.result;


import com.wora.majesticcup.models.DTOs.statistic.StatisticDto;

import java.util.List;

public record ResultDto(
        int team1Goals,
        int team2Goals,
        List<StatisticDto> statistics
) {}