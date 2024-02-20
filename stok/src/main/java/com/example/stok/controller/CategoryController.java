package com.example.stok.controller;

import com.example.stok.dto.CategoryDto;
import com.example.stok.exception.CategoryDeleteException;
import com.example.stok.exception.CategoryNotCreateException;
import com.example.stok.exception.CategoryNotFoundException;
import com.example.stok.response.CategoryResponse;
import com.example.stok.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categoryAdd")
        public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryDto categoryDto) throws CategoryNotCreateException {
        CategoryResponse createCategory=categoryService.create(categoryDto);
        return ResponseEntity.ok(createCategory);
    }
    @GetMapping("/findCategory/{categoryId}")
    public ResponseEntity<CategoryResponse> findCategory(@PathVariable(value = "categoryId") int categoryId) throws CategoryNotFoundException {
        CategoryResponse findCategoryByDto=categoryService.findCategoryByDto(categoryId);
        return ResponseEntity.ok(findCategoryByDto);
    }
    @GetMapping("/getAllCategory")
    public List<CategoryDto> getAllCategory(){

        List<CategoryDto> categoryDtoList=categoryService.getAllCategory();
        return categoryDtoList;
    }
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable (value = "categoryId") int categoryId) throws CategoryDeleteException {
        CategoryResponse response=categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(response);
    }


}
