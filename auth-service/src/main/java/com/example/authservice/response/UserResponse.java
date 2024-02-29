package com.example.authservice.response;

import com.example.authservice.dto.UserDto;

import java.io.Serializable;

public class UserResponse extends BaseResponse implements Serializable {
    public UserDto dto;
}
