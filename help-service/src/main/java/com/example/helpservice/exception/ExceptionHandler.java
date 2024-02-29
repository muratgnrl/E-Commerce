package com.example.helpservice.exception;

import com.example.helpservice.response.AnswersResponse;
import com.example.helpservice.response.Meta;
import com.example.helpservice.response.QuestionsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {
    private final AnswersResponse answersResponse;

    public ExceptionHandler(AnswersResponse answersResponse) {
        this.answersResponse = answersResponse;
    }


    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> answersNotCreatedException(AnswersNotCreateException answersNotCreateException , WebRequest webRequest){
        answersResponse.meta=new Meta(4004,"Yanıt oluşturulamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(answersResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> answersNotFindException(AnswersNotFindException answersNotFindException , WebRequest webRequest){
        answersResponse.meta=new Meta(4004,"Yanıt bulunamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(answersResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> answersNotDeletedException(AnswersNotDeletedException answersNotDeletedException , WebRequest webRequest){
        answersResponse.meta=new Meta(4004,"Yanıt Silinemedi");
        ResponseEntity<Object> entity = new ResponseEntity<>(answersResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> questionsNotDeleteException(QuestionsNotDeleteException questionsNotDeleteException , WebRequest webRequest){
        QuestionsResponse questionsResponse=new QuestionsResponse();
        questionsResponse.meta=new Meta(4004,"Yanıt Silinemedi");
        ResponseEntity<Object> entity = new ResponseEntity<>(questionsResponse, HttpStatus.NOT_FOUND);
        return entity;
    }

}
