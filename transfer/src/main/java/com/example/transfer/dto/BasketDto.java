package com.example.transfer.dto;
import com.example.stock.dto.ProductDto;

import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    public int basketId;
    public double totalAmount;
    public List<ProductDto> productDtoList;
    public int status;
}
