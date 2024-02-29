package com.example.stockservice.dto;


import java.util.List;

public class CategoryDto {
    public int categoryId;

    public String categoryName;
    public String categoryDescription;

    public List<ProductDto> productList;
}
