package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.round.CreateRoundDto;
import com.wora.majesticcup.models.DTOs.round.RoundDto;
import com.wora.majesticcup.models.DTOs.round.UpdateRoundDto;
import com.wora.majesticcup.models.entities.Round;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoundMapper extends GenericMapper<Round, RoundDto> {
    Round toEntity(RoundDto dto);
    Round toEntity(CreateRoundDto dto);
    Round toEntity(UpdateRoundDto dto);
    RoundDto toDto(Round entity);
}