package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.competition.CompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.CreateCompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.UpdateCompetitionDto;
import com.wora.majesticcup.models.entities.Competition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompetitionMapper extends GenericMapper<Competition, CompetitionDto> {
    Competition toEntity(CompetitionDto dto);
    Competition toEntity(CreateCompetitionDto dto);
    Competition toEntity(UpdateCompetitionDto dto);
    CompetitionDto toDto(Competition entity);
}