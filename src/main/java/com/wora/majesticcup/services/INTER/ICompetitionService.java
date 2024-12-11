package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.competition.CompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.CreateCompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.UpdateCompetitionDto;
import com.wora.majesticcup.models.entities.Competition;
import com.wora.majesticcup.services.GenericService;

public interface ICompetitionService extends GenericService<CreateCompetitionDto, UpdateCompetitionDto, CompetitionDto, String> {
    Competition getCompetitionEntityById(String id);
}
