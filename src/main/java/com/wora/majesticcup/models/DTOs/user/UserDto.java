package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;

public record UserDto(
        String id,
        String username,
        Role roles
) {}