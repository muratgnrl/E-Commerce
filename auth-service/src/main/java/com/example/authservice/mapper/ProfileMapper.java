package com.example.authservice.mapper;

import com.example.authservice.dto.ProfileDto;
import com.example.authservice.model.Profile;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProfileMapper extends IEntityMapper<ProfileDto, Profile> {
}
