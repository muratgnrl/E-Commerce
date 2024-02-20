package com.example.stok.service;

import com.example.stok.dto.CategoryDto;
import com.example.stok.exception.CategoryDeleteException;
import com.example.stok.exception.CategoryNotCreateException;
import com.example.stok.exception.CategoryNotFoundException;
import com.example.stok.response.CategoryResponse;
import com.example.stok.model.Category;
import com.example.stok.repository.CategoryRepository;
import com.example.stok.response.Meta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final Logger logger= LoggerFactory.getLogger(CategoryService.class);
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse create(CategoryDto categoryDto) throws CategoryNotCreateException {
        Category category = CategoryDto.toEntity(categoryDto);
        category = categoryRepository.save(category);
        if (category != null) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.category = CategoryDto.toResource(category);
            categoryResponse.meta = new Meta(200, "Kayıt başarılı");
            logger.info("Yeni kategori oluşturuldu: " + category.getCategoryName());
            return categoryResponse;
        } else {
            logger.error("Kategori eklenemedi");
            throw new CategoryNotCreateException();
        }
    }

    public CategoryResponse findCategoryByDto(int categoryId) throws CategoryNotFoundException {
        Category category = findCategory(categoryId);
        if (category != null) {
            CategoryResponse response = new CategoryResponse();
            response.category = CategoryDto.toResource(category);
            response.meta = new Meta(200, "Kategori bulundu");
            logger.info("Kategori bulundu" + category.getCategoryId()) ;
            return response;

        } else {
            logger.error("Kategori bulunamadı");
            throw new CategoryNotFoundException();
        }
    }

    public Category findCategory(int categoryId) {
        Category category = categoryRepository.findCategoryByCategoryId(categoryId);
        CategoryDto.toResource(category);
        return category;
    }


    public CategoryResponse deleteCategory(int categoryId) throws CategoryDeleteException {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            categoryRepository.deleteById(categoryId);
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.meta = new Meta(200, "Kategori silindi : " + categoryId);
            logger.info("Kategori silindi" + category);
            return categoryResponse;
        } else {
            throw new CategoryDeleteException();
        }
    }


    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> categoryDtoList=new ArrayList<>();

        Iterable<Category> categories=categoryRepository.findAll();
        for (Category category: categories){

            CategoryDto categoryDto=CategoryDto.toResource(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
    }


