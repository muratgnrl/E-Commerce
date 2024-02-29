package com.example.helpservice.dto;

import com.example.helpservice.model.Answers;

import java.io.Serializable;

public class AnswersDto implements Serializable {
    public long answersId;
    public String answers;

    public static Answers mapToEntity(AnswersDto answersDto){
        Answers answers =new Answers();
        answers.setAnswers(answersDto.answers);
        answers.setAnswersId(answersDto.answersId);
        return answers;
    }
    public static AnswersDto mapToDto(Answers answers){
        AnswersDto answersDto =new AnswersDto();
        answersDto.answers=answers.getAnswers();
        answersDto.answersId=answers.getAnswersId();

        return answersDto;
    }
}
