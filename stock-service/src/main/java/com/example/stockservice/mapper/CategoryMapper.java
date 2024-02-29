package com.example.stockservice.mapper;

import com.example.stockservice.dto.CategoryDto;
import com.example.stockservice.model.Category;

public class CategoryMapper {
    public static Category mapToEntity(CategoryDto categoryDto){
        Category category =new Category();
        category.setCategoryId(categoryDto.categoryId);
        category.setCategoryName(categoryDto.categoryName);
        category.setCategoryDescription(categoryDto.categoryDescription);
        return category;
    }
    public static CategoryDto mapToDto(Category category){
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.categoryName=category.getCategoryName();
        categoryDto.categoryDescription=category.getCategoryDescription();
        categoryDto.categoryId=category.getCategoryId();
        return categoryDto;
    }

}
