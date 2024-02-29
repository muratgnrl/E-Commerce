package com.example.basketservice.dto;

import java.util.List;

public class BasketDto {
    public long basketId;
    public double totalAmount;
    public List<BasketDetailsDto> basketDetailList;
    public long userId;
    public int status;
}
