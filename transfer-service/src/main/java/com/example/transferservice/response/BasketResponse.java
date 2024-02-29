package com.example.transferservice.response;

import com.example.transferservice.dto.BasketDto;

import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basket;
}
