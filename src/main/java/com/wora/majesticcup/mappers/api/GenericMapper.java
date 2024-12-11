package com.wora.majesticcup.mappers.api;

import java.util.List;

public interface GenericMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}