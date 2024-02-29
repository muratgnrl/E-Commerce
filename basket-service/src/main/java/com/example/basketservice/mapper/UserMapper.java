package com.example.basketservice.mapper;

import com.example.basketservice.dto.UserDto;
import com.example.basketservice.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends IEntityMapper<UserDto, User>{
}
