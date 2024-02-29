package com.example.authservice.exception;

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
    public ResponseEntity<Object> userNotCreateException(UserNotCreateException userNotCreateException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        userResponse.meta=new Meta(4404,"Kullanıcı kayıt başarısız");
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNotFound(UserNotFoundException userNotFoundException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        userResponse.meta=new Meta(4404,"Kullanıcı bulunamadı geçerli kullanıcı giriniz");
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> communicateInformationNotCreate(CommunicateInformationNotCreateException communicateInformationNotCreateException , WebRequest webRequest){
        CommunicateInformationResponse communicateInformationResponse=new CommunicateInformationResponse();
        communicateInformationResponse.meta=new Meta(4404,"Kullanıcı bilgileri eklenemedi");
        ResponseEntity<Object> entity=new ResponseEntity<>(communicateInformationResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNorDeleted(UserNotDeletedException userNotDeletedException , WebRequest webRequest){
        UserResponse userResponse=new UserResponse();
        userResponse.meta=new Meta(4404,"Kullanıcı silinemedi");
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> communicateInformationDeleted(CommunicateInformationNotDeleted communicateInformationNotDeleted , WebRequest webRequest){
        CommunicateInformationResponse communicateInformationResponse=new CommunicateInformationResponse();
        communicateInformationResponse.meta=new Meta(4404,"Kullanıcı iletişim bilgileri silinemedi");
        ResponseEntity<Object> entity=new ResponseEntity<>(communicateInformationResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> userNotLoginException(UserNotLoginException userNotLoginException , WebRequest webRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.meta = new Meta(4404, "Kullanıcı giriş başarısız");
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
