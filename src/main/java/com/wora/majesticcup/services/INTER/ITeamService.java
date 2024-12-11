package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.team.CreateTeamDto;
import com.wora.majesticcup.models.DTOs.team.TeamDto;
import com.wora.majesticcup.models.DTOs.team.UpdateTeamDto;
import com.wora.majesticcup.models.entities.Team;
import com.wora.majesticcup.services.GenericService;

public interface ITeamService extends GenericService<CreateTeamDto, UpdateTeamDto, TeamDto, String> {
    Team getTeamEntityById(String id);
}
