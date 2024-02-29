package com.example.basketservice.dto;

import java.io.Serializable;

public class AddBasketDto implements Serializable {
    public long userId;
    public long productId;
    public int count;
    public long basketId;
    public long paymentId;
}
