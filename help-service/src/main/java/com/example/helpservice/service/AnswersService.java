package com.example.helpservice.service;

import com.example.helpservice.dto.AnswersDto;
import com.example.helpservice.exception.ExceptionAnswers;
import com.example.helpservice.exception.ExceptionDeleteAnswers;
import com.example.helpservice.response.AnswersResponse;

public interface AnswersService {
    AnswersResponse addAnswers(AnswersDto answersDto) throws ExceptionAnswers;

    AnswersResponse deleteAnswers(long answersId) throws ExceptionDeleteAnswers;
}
