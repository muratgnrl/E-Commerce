package com.example.helpservice.service;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.exception.AnswersNotCreateException;
import com.example.helpservice.exception.AnswersNotDeletedException;
import com.example.helpservice.exception.AnswersNotFindException;
import com.example.helpservice.response.AnswersResponse;

import java.util.List;

public interface AnswersService {
    AnswersResponse addAnswers(AnswersDto answersDto) throws AnswersNotCreateException;

    List<AnswersDto> getallAnswers();

    AnswersResponse deleteAnswers(long answersId) throws AnswersNotDeletedException;

    AnswersDto updateAnswers(AnswersDto dto, long answersId);

    AnswersResponse getAnswers(long answersId) throws AnswersNotFindException;
}
