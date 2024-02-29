package com.example.stockservice.service;

import com.example.stockservice.dto.CategoryDto;
import com.example.stockservice.exception.CategoryDeleteException;
import com.example.stockservice.exception.CategoryGetAllException;
import com.example.stockservice.exception.CategoryNotCreate;
import com.example.stockservice.exception.CategoryNotFoundException;
import com.example.stockservice.response.CategoryRespone;

import java.util.List;

public interface CategoryService {
    CategoryRespone saveCategory(CategoryDto dto) throws CategoryNotCreate;

     List<CategoryDto> getAllCategory() throws CategoryGetAllException;

    CategoryRespone findCategory(long categoryId) throws CategoryNotFoundException;

    CategoryRespone deletedCategory(long categoryId) throws CategoryDeleteException;
}
