package com.example.stok.dto;


import lombok.Data;


import java.io.Serializable;
@Data
public class ProductDto implements Serializable {

    public int productId;

    public String productName;

    public String productDescprition;

    public int productAmount;

    public int categoryId;

}
