package com.example.basket.response;

import com.example.basket.dto.ProductDto;

import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto productDto;
}
