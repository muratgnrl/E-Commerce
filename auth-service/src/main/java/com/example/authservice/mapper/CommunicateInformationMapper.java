package com.example.authservice.mapper;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.model.CommunicateInformation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface CommunicateInformationMapper extends IEntityMapper<CommunicateInformationDto, CommunicateInformation> {
}
