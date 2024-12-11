package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.match.CreateMatchDto;
import com.wora.majesticcup.models.DTOs.match.MatchDto;
import com.wora.majesticcup.models.DTOs.match.UpdateMatchDto;
import com.wora.majesticcup.models.entities.Match;
import com.wora.majesticcup.services.GenericService;

public interface IMatchService extends GenericService<CreateMatchDto, UpdateMatchDto, MatchDto, String> {
    Match getMatchEntityById(String id);
}
