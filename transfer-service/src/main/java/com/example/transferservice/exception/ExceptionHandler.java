package com.example.transferservice.exception;

import com.example.transferservice.response.Meta;
import com.example.transferservice.response.TransferResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> transferException(TransferException transferException, WebRequest webRequest){

        TransferResponse transferResponse =new TransferResponse();
        transferResponse.meta=new Meta(4004,"Ürün veya ürünler gönderilemedi");
        ResponseEntity<Object>entity =new ResponseEntity<>(transferResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
}
