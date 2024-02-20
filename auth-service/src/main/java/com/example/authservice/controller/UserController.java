package com.example.authservice.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.authservice.dto.UserDto;
import com.example.authservice.exception.UserNotCreateException;
import com.example.authservice.exception.UserNotDeletedException;
import com.example.authservice.exception.UserNotFoundException;
import com.example.authservice.exception.UserNotLoginException;
import com.example.authservice.response.UserResponse;
import com.example.authservice.service.impl.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto userDto) throws UserNotCreateException {
        UserResponse create=service.createUser(userDto);
        return ResponseEntity.ok(create);
    }
    @PostMapping("/loginUser")
    public ResponseEntity<UserResponse> login(@RequestBody UserDto userDto) throws UserNotLoginException {
        UserResponse login = service.login(userDto);
        return ResponseEntity.ok(login);
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserResponse> findUserByDto(@PathVariable (value = "id") long id) throws UserNotFoundException {
        UserResponse findUser = service.findUserByDto(id);
        return ResponseEntity.ok(findUser);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> getAllUser = service.getAllUser();
        return ResponseEntity.ok(getAllUser);
    }
    @PutMapping("/update/user/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto,
                                              @PathVariable (value = "id") long id) {
        UserDto updateUser = service.updateUser(dto,id);
        return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable (value = "id") long id) throws UserNotDeletedException {
        UserResponse deleteUser = service.deleteUser(id);
        return ResponseEntity.ok(deleteUser);
    }
}
