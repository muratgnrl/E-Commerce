package com.example.stockservice.response;

import com.example.stockservice.dto.ProductDto;

import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto product;
}
