package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;

import java.util.List;

public record UpdateUserDto(
        String username,
        Role roles
) {}