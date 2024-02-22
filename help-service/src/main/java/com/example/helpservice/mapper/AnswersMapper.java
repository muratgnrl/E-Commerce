package com.example.helpservice.mapper;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.entity.Answers;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AnswersMapper extends IEntityMapper<AnswersDto, Answers>{
}
