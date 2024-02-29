package com.example.authservice.mapper;

import com.example.authservice.dto.UserDto;
import com.example.authservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User>{
}
