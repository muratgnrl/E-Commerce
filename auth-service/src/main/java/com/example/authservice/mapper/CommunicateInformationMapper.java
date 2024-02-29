package com.example.authservice.mapper;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.entity.CommunicateInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunicateInformationMapper extends IEntityMapper<CommunicateInformationDto, CommunicateInformation>{
}
