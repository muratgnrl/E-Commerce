package com.example.helpservice.exception;

import com.example.helpservice.response.AnswersResponse;
import com.example.helpservice.response.Meta;
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
    public ResponseEntity<Object> addAnswersException (ExceptionAnswers exceptionAnswers , WebRequest webRequest){
        Meta meta=new Meta();
        meta.errorCode=4004;
        meta.errorDescription="No reply added";
        answersResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(answersResponse , HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteAnswers (ExceptionDeleteAnswers exceptionDeleteAnswers , WebRequest webRequest){
        Meta meta=new Meta();
        meta.errorCode=4004;
        meta.errorDescription="Reply could not be deleted";
        answersResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(answersResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> exceptionQuestions (ExceptionQuestion exceptionQuestion , WebRequest webRequest){
        Meta meta=new Meta();
        meta.errorCode=4004;
        meta.errorDescription="Questions not added";
        answersResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(answersResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> exceptionNotFoundQuestions (ExceptionNotFoundQuestions exceptionNotFoundQuestions , WebRequest webRequest){
        Meta meta=new Meta();
        meta.errorCode=4004;
        meta.errorDescription="Questions not found";
        answersResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(answersResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
}
