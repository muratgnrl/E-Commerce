package com.example.authservice.controller;

import com.example.authservice.dto.UserDto;
import com.example.authservice.entity.User;
import com.example.authservice.exception.UserNotCreateException;
import com.example.authservice.exception.UserNotDeletedException;
import com.example.authservice.exception.UserNotFoundException;
import com.example.authservice.exception.UserNotLoginException;
import com.example.authservice.response.UserResponse;
import com.example.authservice.service.UserService;
import com.example.authservice.service.ımpl.UserServiceImpl;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserDto userDto) throws UserNotCreateException {
        UserResponse addUser=userService.addUser(userDto);
        return ResponseEntity.ok(addUser);
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserDto userDto) throws UserNotLoginException {
        UserResponse login =userService.login(userDto);
        return ResponseEntity.ok(login);
    }
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(value = "userId") long userId) throws UserNotFoundException {
        UserResponse getUser = userService.getUser(userId);
        return ResponseEntity.ok(getUser);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> getAllUser = userService.getAllUser();
        return ResponseEntity.ok(getAllUser);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<UserResponse>  deleteUser(@PathVariable (value = "userId") long userId) throws UserNotDeletedException {
        UserResponse deleteUser=userService.deleteUser(userId);
        return ResponseEntity.ok(deleteUser);
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto,
                                              @PathVariable (value = "userId") long userId) {
        UserDto updateUser = userService.updateUser(dto,userId);
        return ResponseEntity.ok(updateUser);
    }
}
