package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.match.CreateMatchDto;
import com.wora.majesticcup.models.DTOs.match.MatchDto;
import com.wora.majesticcup.models.DTOs.match.UpdateMatchDto;
import com.wora.majesticcup.models.entities.Match;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper extends GenericMapper<Match, MatchDto> {
    Match toEntity(MatchDto dto);
    Match toEntity(CreateMatchDto dto);
    Match toEntity(UpdateMatchDto dto);
    MatchDto toDto(Match entity);

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