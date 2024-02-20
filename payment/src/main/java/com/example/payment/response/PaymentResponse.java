package com.example.payment.response;

import com.example.payment.dto.PaymentDto;

import java.io.Serializable;

public class PaymentResponse extends BaseResponse implements Serializable {
    public PaymentDto paymentDto;
}
