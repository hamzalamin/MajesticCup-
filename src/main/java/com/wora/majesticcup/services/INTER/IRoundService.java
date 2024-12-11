package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.round.CreateRoundDto;
import com.wora.majesticcup.models.DTOs.round.RoundDto;
import com.wora.majesticcup.models.DTOs.round.UpdateRoundDto;
import com.wora.majesticcup.models.entities.Round;
import com.wora.majesticcup.services.GenericService;

public interface IRoundService extends GenericService<CreateRoundDto, UpdateRoundDto, RoundDto, String> {
    Round getRoundEntityById(String id);

}
