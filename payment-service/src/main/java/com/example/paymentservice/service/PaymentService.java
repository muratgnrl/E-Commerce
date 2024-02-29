package com.example.paymentservice.service;

import com.example.paymentservice.dto.DoPayDto;
import com.example.paymentservice.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse doPay(DoPayDto doPayDto);
}
