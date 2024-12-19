package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.round.CreateRoundDto;
import com.wora.majesticcup.models.DTOs.round.RoundDto;
import com.wora.majesticcup.models.DTOs.round.UpdateRoundDto;
import com.wora.majesticcup.models.entities.Round;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoundMapper extends GenericMapper<Round, RoundDto> {
    Round toEntity(RoundDto dto);
    Round toEntity(CreateRoundDto dto);
    Round toEntity(UpdateRoundDto dto);
    RoundDto toDto(Round entity);

    default Player map(String playerId) {
        if (playerId == null) {
            return null;
        }
        return new Player(playerId); // Assuming Player has a constructor that accepts a String
    }

    // Reverse mapping for Player to String
    default String map(Player player) {
        if (player == null) {
            return null;
        }
        return player.getId(); // Assuming Player has a getId() method
    }
}