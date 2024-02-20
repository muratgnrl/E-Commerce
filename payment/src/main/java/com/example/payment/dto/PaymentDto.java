package com.example.payment.dto;

import java.io.Serializable;

public class PaymentDto implements Serializable {
    public int paymentId;
    public int cardNumber;
    public int cardCCV;
    public int expirationDate;

}