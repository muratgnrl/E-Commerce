package com.example.authservice.exception;

import com.example.authservice.model.CommunicateInformation;
import com.example.authservice.response.CommunicateInformationResponse;
import com.example.authservice.response.Meta;
import com.example.authservice.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNotFoundException (UserNotFoundException userNotFoundException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta(4044,"User not found failed ! ! !");
        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNotCreateException (UserNotCreateException userNotCreateException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta(4014,"Registration failed ! ! !");
        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNotDeletedException (UserNotDeletedException userNotDeletedException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta(4050,"User deletion failed");
        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNotLoginException (UserNotLoginException userNotLoginException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta(4020,"Login is incorrect, please check your email or password.");
        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> communicateInformationNotCreate (CommunicateInformationNotCreateException communicateInformationNotCreateException , WebRequest webRequest){
        CommunicateInformationResponse communicateInformationResponse=new CommunicateInformationResponse();
        Meta meta=new Meta(4000,"contact information could not be added");
        communicateInformationResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(communicateInformationResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> communicateInformationDeleted (CommunicateInformationDeletedException communicateInformationDeletedException , WebRequest webRequest) {
        CommunicateInformationResponse communicateInformationResponse = new CommunicateInformationResponse();
        Meta meta = new Meta(4041, "Information Contact could not be deleted");
        communicateInformationResponse.meta = meta;
        ResponseEntity<Object> entity = new ResponseEntity<>(communicateInformationResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
