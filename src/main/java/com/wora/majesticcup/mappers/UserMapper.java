package com.wora.majesticcup.mappers;

import com.wora.majesticcup.mappers.api.GenericMapper;
import com.wora.majesticcup.models.DTOs.user.CreateUserDto;
import com.wora.majesticcup.models.DTOs.user.UpdateUserDto;
import com.wora.majesticcup.models.DTOs.user.UserDto;
import com.wora.majesticcup.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDto> {
    User toEntity(UserDto dto);
    User toEntity(CreateUserDto dto);
    User toEntity(UpdateUserDto dto);
    UserDto toDto(User entity);
}