package com.example.paymentservice.exception;

import com.example.paymentservice.response.Meta;
import com.example.paymentservice.response.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {



    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> paymentException(PaymentException paymentException, WebRequest webRequest){
        PaymentResponse paymentResponse =new PaymentResponse();
        paymentResponse.meta=new Meta(4044," Ödeme tamamlanamadı");
        ResponseEntity<Object> entity =new ResponseEntity<>(paymentResponse , HttpStatus.NOT_FOUND);
        return entity;
    }
}
