package com.example.basket.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
    public int productId;
    public String productName;
    public String productDescription;
    public int productAmount;
    public int basketId;
}
