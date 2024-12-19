package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.user.ChangePasswordDto;
import com.wora.majesticcup.models.DTOs.user.CreateUserDto;
import com.wora.majesticcup.models.DTOs.user.UpdateUserDto;
import com.wora.majesticcup.models.DTOs.user.UserDto;
import com.wora.majesticcup.services.INTER.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserDto createUserDto) {
        UserDto userDto = userService.save(createUserDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        UserDto userDto = userService.findById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> update(
            @RequestBody @Valid UpdateUserDto updateUserDto,
            @PathVariable String id
    ) {
        UserDto updatedUser = userService.update(updateUserDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<UserDto> users = userService.findAll(pageNumber, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        userService.delete(id);
        return new ResponseEntity<>("User with ID " + id + " deleted successfully.", HttpStatus.OK);
    }

    @PutMapping("/users/change-password/{name}")
    public ResponseEntity<String> changePassword(
            @RequestBody @Valid ChangePasswordDto changePasswordDto,
            @PathVariable String name
    ) {
        userService.changePassword(changePasswordDto, name);
        return new ResponseEntity<>("Password updated successfully.", HttpStatus.OK);
    }
}
