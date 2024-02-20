package com.example.help.exception;

import com.example.help.model.Questions;
import com.example.help.response.Meta;
import com.example.help.response.QuestionsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.MalformedParameterizedTypeException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addException(ExceptionQuestions exceptionQuestions , WebRequest webRequest){
        Meta meta=new Meta();
        QuestionsResponse questionsResponse=new QuestionsResponse();

        meta.errorCode = 4001;
        meta.errorDescription="Soru eklemede bir sorun oluştu";
        questionsResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(questionsResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
}
