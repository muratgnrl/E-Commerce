package com.example.authservice.mapper;

import com.example.authservice.dto.UserDto;
import com.example.authservice.model.User;
import jakarta.persistence.EntityManager;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper extends IEntityMapper<UserDto, User> {
}
