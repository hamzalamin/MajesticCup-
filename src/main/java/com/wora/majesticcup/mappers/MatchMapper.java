package com.wora.majesticcup.mappers;

import com.wora.majesticcup.models.DTOs.match.CreateMatchDto;
import com.wora.majesticcup.models.DTOs.match.MatchDto;
import com.wora.majesticcup.models.DTOs.match.UpdateMatchDto;
import com.wora.majesticcup.models.entities.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    Match toEntity(CreateMatchDto dto);
    Match toEntity(UpdateMatchDto dto);
    MatchDto toDto(Match entity);
}