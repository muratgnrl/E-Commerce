package com.example.paymentservice.dto;

import java.io.Serializable;

public class PaymentDto implements Serializable {
    public long paymentId;
    public int cardNumber;
    public int cardCCV;
    public int expirationDate;
}
