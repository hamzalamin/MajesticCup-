package com.wora.majesticcup.models.DTOs.user;

import com.wora.majesticcup.models.enumes.Role;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserDto(
        String id,
        String username,
        List<String> roles
) {}