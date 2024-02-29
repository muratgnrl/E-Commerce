package com.example.basketservice.response;

import com.example.basketservice.dto.PaymentDto;

import java.io.Serializable;

public class PaymentResponse extends BaseResponse implements Serializable {
    public PaymentDto paymentDto;
}
