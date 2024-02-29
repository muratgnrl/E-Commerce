package com.example.stockservice.response;

import com.example.stockservice.dto.CategoryDto;

import java.io.Serializable;

public class CategoryRespone extends BaseResponse implements Serializable {
    public CategoryDto category;
}
