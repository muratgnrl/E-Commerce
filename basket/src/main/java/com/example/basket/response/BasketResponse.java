package com.example.basket.response;

import com.example.basket.dto.BasketDto;

import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
