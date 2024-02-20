package com.example.basket.response;

import com.example.basket.dto.PaymentDto;

import java.io.Serializable;

public class PaymentResponse extends BaseResponse implements Serializable {
    public PaymentDto paymentDto;
}
