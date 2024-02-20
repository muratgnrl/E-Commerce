package com.example.payment.controller;

import com.example.payment.dto.DoPayDto;
import com.example.payment.dto.PaymentDto;
import com.example.payment.response.PaymentResponse;
import com.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/doPay")
    public PaymentResponse doPay(@RequestBody DoPayDto doPay){
        return paymentService.doPay(doPay);
    }
}
