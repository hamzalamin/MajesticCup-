package com.wora.majesticcup.mappers;

import com.wora.majesticcup.models.DTOs.team.CreateTeamDto;
import com.wora.majesticcup.models.DTOs.team.TeamDto;
import com.wora.majesticcup.models.DTOs.team.UpdateTeamDto;
import com.wora.majesticcup.models.entities.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    Team toEntity(CreateTeamDto dto);
    Team toEntity(UpdateTeamDto dto);
    TeamDto toDto(Team entity);
}