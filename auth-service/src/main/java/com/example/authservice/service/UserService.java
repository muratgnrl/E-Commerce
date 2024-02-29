package com.example.authservice.service;

import com.example.authservice.dto.UserDto;
import com.example.authservice.exception.UserNotCreateException;
import com.example.authservice.exception.UserNotDeletedException;
import com.example.authservice.exception.UserNotFoundException;
import com.example.authservice.exception.UserNotLoginException;
import com.example.authservice.response.UserResponse;

import java.util.List;


public interface UserService {
    UserResponse getUser(long userId) throws UserNotFoundException;
    UserResponse addUser(UserDto userDto) throws UserNotCreateException;
    UserResponse deleteUser(long userId) throws UserNotDeletedException;
    List<UserDto> getAllUser();
    UserResponse login(UserDto userDto) throws UserNotLoginException;

    UserDto updateUser(UserDto dto, long userId);
}
