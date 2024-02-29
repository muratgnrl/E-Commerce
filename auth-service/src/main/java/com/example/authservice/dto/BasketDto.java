package com.example.authservice.dto;

import java.util.List;

public class BasketDto {
    public int basketId;
    public double totalAmount;
    public List<ProductDto> productList;
    public int status;
}
