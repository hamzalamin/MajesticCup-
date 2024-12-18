package com.wora.majesticcup.models.DTOs.player;

public record PlayerDto(
        String id,
        String name,
        String surname,
        String position,
        int number
) {}