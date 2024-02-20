package com.example.authservice.service.impl;

import com.example.authservice.dto.UserDto;
import com.example.authservice.exception.UserNotCreateException;
import com.example.authservice.exception.UserNotDeletedException;
import com.example.authservice.exception.UserNotFoundException;
import com.example.authservice.exception.UserNotLoginException;
import com.example.authservice.mapper.UserMapper;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.response.BasketResponse;
import com.example.authservice.response.Meta;
import com.example.authservice.response.UserResponse;
import com.example.authservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserResponse response;
    private final Logger logger= LoggerFactory.getLogger(UserService.class);

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserResponse response) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.response = response;
    }

    public BasketResponse takeAllActiveBasket(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/{{basketId}}"+basketId, BasketResponse.class);
    }

    @Override
    public UserResponse createUser(UserDto userDto) throws UserNotCreateException {

        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        if (user != null) {
            response.meta = new Meta(200, "Registration Successful");
            response.userDto = userMapper.toResource(user);
            logger.info("User registration successful" + userDto.toString());
            return response;
        } else {
            logger.error("User registration failed");
            throw new UserNotCreateException();
        }
    }
        @Override
        public UserResponse login(UserDto userDto) throws UserNotLoginException {
            User user = userRepository.findUserByMailAndPassword(userDto.mail , userDto.password);
            if (user!=null){
                response.meta=new Meta(200,"User Login successful");
                response.userDto=userMapper.toResource(user);
                logger.info("Login successful" + user);
                return response;
            }else {
                logger.error("Login is incorrect");
                throw new UserNotLoginException();
            }
        }


    @Override
    public UserResponse findUserByDto(long id) throws UserNotFoundException {
        User user=findUser(id);
        if (user!=null){
            response.meta=new Meta(200,"User found successfully" +" =  " + id);
            response.userDto=userMapper.toResource(user);
            logger.info("User found");
            return response;
        }else {
            logger.error("User not found");
            throw new UserNotFoundException();
        }
    }

    public User findUser(long id) {
        User user=userRepository.findUserById(id);
        userMapper.toResource(user);
        return user;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos = new ArrayList<>();

        Iterable<User> users = userRepository.findAll();

        for (User user : users){

            UserDto userDto = userMapper.toResource(user);
            userDtos.add(userDto);

        }
        return userDtos;
    }

    @Override
    public UserResponse deleteUser(long id) throws UserNotDeletedException {
        User user = userRepository.findUserById(id);
        if (user!=null){
            userRepository.deleteById(id);
            response.meta=new Meta(200,"User deleted successfully" + "  = " + " " + id);
            response.userDto=userMapper.toResource(user);
            logger.info("User deleted");
            return response;

        }else {
            throw new UserNotDeletedException();
        }
    }

    @Override
    public UserDto updateUser(UserDto dto, long id) {
        User userDto = userMapper.toEntity(dto);
        User user = userRepository.findUserById(id);

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMail(userDto.getMail());
        user.setPassword(userDto.getPassword());
        user.setProfile(userDto.getProfile());

        User updateUser = userRepository.save(user);

        UserDto userToDto = userMapper.toResource(updateUser);

        return userToDto;
    }




}
