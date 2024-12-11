package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.statistic.CreateStatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.StatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.UpdateStatisticDto;
import com.wora.majesticcup.services.GenericService;

public interface IStatisticService extends GenericService<CreateStatisticDto, UpdateStatisticDto, StatisticDto, String> {
}
