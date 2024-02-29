package com.example.basketservice.response;

import com.example.basketservice.dto.ProductDto;

import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto productDto;
}
