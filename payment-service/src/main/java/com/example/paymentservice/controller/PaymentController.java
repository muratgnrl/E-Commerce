package com.example.paymentservice.controller;

import com.example.paymentservice.dto.DoPayDto;
import com.example.paymentservice.response.PaymentResponse;
import com.example.paymentservice.service.ımpl.PaymentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/doPay")
    public ResponseEntity<PaymentResponse> doPay(@RequestBody DoPayDto doPayDto){
        PaymentResponse doPay=paymentService.doPay(doPayDto);
        return ResponseEntity.ok(doPay);
    }
}
