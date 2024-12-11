package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.player.CreatePlayerDto;
import com.wora.majesticcup.models.DTOs.player.PlayerDto;
import com.wora.majesticcup.models.DTOs.player.UpdatePlayerDto;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import com.wora.majesticcup.services.GenericService;

public interface IPlayerService extends GenericService<CreatePlayerDto, UpdatePlayerDto, PlayerDto, String> {
    Player findEntityById(String id);
}
