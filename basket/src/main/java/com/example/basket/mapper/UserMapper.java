package com.example.basket.mapper;

import com.example.basket.dto.UserDto;
import com.example.basket.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User>{
}
