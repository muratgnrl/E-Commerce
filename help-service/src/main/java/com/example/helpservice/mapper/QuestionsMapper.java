package com.example.helpservice.mapper;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.entity.Questions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionsMapper extends IEntityMapper<QuestionsDto, Questions>{
}
