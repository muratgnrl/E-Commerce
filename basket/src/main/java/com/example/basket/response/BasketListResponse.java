package com.example.basket.response;

import com.example.basket.dto.BasketDetailsDto;
import com.example.basket.dto.BasketDto;

import java.io.Serializable;
import java.util.List;

public class BasketListResponse extends BaseResponse implements Serializable {
    public List<BasketDto> basketDtoList;
}
