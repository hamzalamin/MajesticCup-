package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.player.CreatePlayerDto;
import com.wora.majesticcup.models.DTOs.player.PlayerDto;
import com.wora.majesticcup.models.DTOs.player.UpdatePlayerDto;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends GenericMapper<Player, PlayerDto> {
    Player toEntity(PlayerDto dto);
    Player toEntity(CreatePlayerDto dto);
    Player toEntity(UpdatePlayerDto dto);
    PlayerDto toDto(Player entity);
}