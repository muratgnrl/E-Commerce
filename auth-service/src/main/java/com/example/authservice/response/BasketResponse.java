package com.example.authservice.response;

import com.example.authservice.dto.BasketDto;

import java.io.Serializable;

public class BasketResponse extends BaseResponse implements Serializable {
    public BasketDto basketDto;
}
