package com.example.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long productId;
    private String productName;
    private String productDescprition;
    private int productAmount;
    private int productStockInformation;
    private long catergoryId;

}
