package com.example.helpservice.service;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.exception.ExceptionNotFoundQuestions;
import com.example.helpservice.exception.ExceptionQuestion;
import com.example.helpservice.response.QuestionsResponse;

public interface QuestionsService {
    QuestionsResponse addQuestions(QuestionsDto questionsDto) throws ExceptionQuestion;

    QuestionsResponse findQuestionsByDto(long questionsId) throws ExceptionNotFoundQuestions;
}
