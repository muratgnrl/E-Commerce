package com.example.stok.response;

import com.example.stok.dto.CategoryDto;

import java.io.Serializable;

public class CategoryResponse  extends BaseResponse implements Serializable  {
    public CategoryDto category;
}
