package com.wora.majesticcup.models.DTOs.user;

import java.util.List;

public record UpdateUserDto(
        String username,
        List<String> roles
) {}