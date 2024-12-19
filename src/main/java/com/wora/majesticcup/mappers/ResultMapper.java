package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import com.wora.majesticcup.models.DTOs.result.ResultDto;
import com.wora.majesticcup.models.DTOs.result.UpdateResultDto;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import com.wora.majesticcup.models.entities.embeddedDocuments.Result;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultMapper extends GenericMapper<Result, ResultDto> {
    Result toEntity(ResultDto dto);
    Result toEntity(CreateResultDto dto);
    Result toEntity(UpdateResultDto dto);
    ResultDto toDto(Result entity);

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