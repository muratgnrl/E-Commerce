package com.example.helpservice.service;

import com.example.helpservice.dto.QuestionsDto;
import com.example.helpservice.exception.QuestionsNotCreateException;
import com.example.helpservice.exception.QuestionsNotDeleteException;
import com.example.helpservice.response.QuestionsResponse;

public interface QuestionsService {
     QuestionsResponse deleteQuestions(long questionsId) throws QuestionsNotDeleteException;
    QuestionsResponse addQuestions(QuestionsDto questionsDto) throws QuestionsNotCreateException;
}
