package com.example.basket.response;

import com.example.basket.dto.UserDto;

import java.io.Serializable;

public class UserResponse extends BaseResponse implements Serializable {
    public UserDto userDto;
}
