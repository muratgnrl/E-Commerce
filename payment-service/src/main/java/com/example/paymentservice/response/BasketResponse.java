package com.example.paymentservice.response;

import com.example.paymentservice.dto.BasketDto;

import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
