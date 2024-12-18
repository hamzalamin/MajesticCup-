package com.wora.majesticcup.models.DTOs.user;

import java.util.List;

public record CreateUserDto(
        String username,
        String password,
        List<String> roles
) {}