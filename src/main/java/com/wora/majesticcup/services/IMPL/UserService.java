package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.exceptions.OwnPasswordException;
import com.wora.majesticcup.exceptions.PasswordIncorrect;
import com.wora.majesticcup.mappers.UserMapper;
import com.wora.majesticcup.models.DTOs.user.ChangePasswordDto;
import com.wora.majesticcup.models.DTOs.user.CreateUserDto;
import com.wora.majesticcup.models.DTOs.user.UpdateUserDto;
import com.wora.majesticcup.models.DTOs.user.UserDto;
import com.wora.majesticcup.models.entities.User;
import com.wora.majesticcup.models.enumes.Role;
import com.wora.majesticcup.repositories.UserRepository;
import com.wora.majesticcup.services.INTER.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        User user = userMapper.toEntity(createUserDto);
        String encodedPassword = passwordEncoder.encode(createUserDto.password());
        user.setPassword(encodedPassword);

        Role defaultRole = Role.OPERATOR;
        user.setRoles(defaultRole);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto findById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto update(UpdateUserDto updateUserDto, String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));

        user.setUsername(updateUserDto.username());
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public List<UserDto> findAll(Integer pageNumber, Integer size) {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
        userRepository.delete(user);
    }


    @Override
    public void changePassword(ChangePasswordDto changePasswordDto, String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("User", name));


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!authentication.getName().equals(name)) {
            throw new OwnPasswordException("You can only change your own password");
        }

        if (!passwordEncoder.matches(changePasswordDto.oldPassword(), user.getPassword())) {
            throw new PasswordIncorrect("Old password is incorrect.");
        }
        String encodedNewPassword = passwordEncoder.encode(changePasswordDto.newPassword());
        user.setPassword(encodedNewPassword);
        userRepository.save(user);
    }

}
