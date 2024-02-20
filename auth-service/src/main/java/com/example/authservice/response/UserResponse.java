package com.example.authservice.response;

import com.example.authservice.dto.UserDto;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class UserResponse extends BaseResponse implements Serializable {
    public UserDto userDto;
}
