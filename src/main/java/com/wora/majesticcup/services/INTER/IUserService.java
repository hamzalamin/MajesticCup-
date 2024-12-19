package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.user.ChangePasswordDto;
import com.wora.majesticcup.models.DTOs.user.CreateUserDto;
import com.wora.majesticcup.models.DTOs.user.UpdateUserDto;
import com.wora.majesticcup.models.DTOs.user.UserDto;
import com.wora.majesticcup.services.GenericService;

public interface IUserService extends GenericService<CreateUserDto, UpdateUserDto, UserDto, String> {
    void changePassword(ChangePasswordDto changePasswordDto, String name);
}