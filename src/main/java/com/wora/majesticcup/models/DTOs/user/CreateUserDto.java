package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;

import java.util.List;

public record CreateUserDto(
        String username,
        String password,
        Role roles
) {}