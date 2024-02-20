package com.example.basket.exception;

import com.example.basket.response.Meta;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(FindException.class)
    public ResponseEntity<Object> handleExceptions(FindException exception, WebRequest webRequest) {
        Meta response = new Meta();
        response.errorCode = 5007;
        response.errorDescription = "Basket bulunamadı";
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(EntityNotFoundException exception, WebRequest webRequest) {
        Meta response = new Meta();
        response.errorCode = 5007;
        response.errorDescription = "Entity bulunamadı";
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
