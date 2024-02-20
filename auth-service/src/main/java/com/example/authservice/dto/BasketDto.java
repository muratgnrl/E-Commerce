package com.example.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto implements Serializable {
    private long basketId;
    private double totalAmount;
    private List<ProductDto> productList;
    private int status;
}
