package com.example.authservice.service;

import com.example.authservice.dto.UserDto;
import com.example.authservice.exception.UserNotCreateException;
import com.example.authservice.exception.UserNotDeletedException;
import com.example.authservice.exception.UserNotFoundException;
import com.example.authservice.exception.UserNotLoginException;
import com.example.authservice.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserDto userDto) throws UserNotCreateException;

    UserResponse findUserByDto(long id) throws UserNotFoundException;

    List<UserDto> getAllUser();

    UserResponse deleteUser(long id) throws UserNotDeletedException;

    UserDto updateUser(UserDto dto, long id);

    UserResponse login(UserDto userDto) throws UserNotLoginException;
}
