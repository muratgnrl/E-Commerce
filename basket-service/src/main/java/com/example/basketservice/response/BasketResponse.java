package com.example.basketservice.response;

import com.example.basketservice.dto.BasketDto;
import com.example.basketservice.entity.BasketDetails;

import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
