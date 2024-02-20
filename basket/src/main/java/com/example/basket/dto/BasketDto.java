package com.example.basket.dto;


import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    public int basketId;
    public double totalAmount;
    public List<BasketDetailsDto>basketDetailsList;
    public int  status;
    public int userId;
}
