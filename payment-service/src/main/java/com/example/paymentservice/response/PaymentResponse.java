package com.example.paymentservice.response;

import com.example.paymentservice.dto.PaymentDto;

import java.io.Serializable;

public class PaymentResponse extends BaseResponse implements Serializable {
    public PaymentDto paymentDto;
}
