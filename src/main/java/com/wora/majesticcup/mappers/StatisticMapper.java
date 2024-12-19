package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.statistic.CreateStatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.StatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.UpdateStatisticDto;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import com.wora.majesticcup.models.entities.embeddedDocuments.Statistic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticMapper extends GenericMapper<Statistic, StatisticDto> {
    Statistic toEntity(StatisticDto dto);
    Statistic toEntity(CreateStatisticDto dto);
    Statistic toEntity(UpdateStatisticDto dto);
    StatisticDto toDto(Statistic entity);

    default Player map(String playerId) {
        if (playerId == null) {
            return null;
        }
        return new Player(playerId);
    }

    default String map(Player player) {
        if (player == null) {
            return null;
        }
        return player.getId();
    }
}