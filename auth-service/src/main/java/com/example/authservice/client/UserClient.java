package com.example.authservice.client;

import com.example.authservice.dto.UserDto;
import com.example.authservice.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserClient {
    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto userDto) ;
}