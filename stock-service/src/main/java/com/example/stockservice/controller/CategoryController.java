package com.example.stockservice.controller;

import com.example.stockservice.dto.CategoryDto;
import com.example.stockservice.exception.CategoryDeleteException;
import com.example.stockservice.exception.CategoryGetAllException;
import com.example.stockservice.exception.CategoryNotCreate;
import com.example.stockservice.exception.CategoryNotFoundException;
import com.example.stockservice.response.CategoryRespone;
import com.example.stockservice.service.ımpl.CategoryServiceImpl;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kategori")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryRespone> saveCategory(@RequestBody CategoryDto dto) throws CategoryNotCreate {
        CategoryRespone saveCategory = categoryService.saveCategory(dto);
        return ResponseEntity.ok(saveCategory);
    }
    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory() throws CategoryGetAllException {
        List<CategoryDto> getAllCategory =categoryService.getAllCategory();
        return ResponseEntity.ok(getAllCategory);
    }
    @GetMapping("/find/{categoryId}")
    public ResponseEntity<CategoryRespone> findCategory(@PathVariable (value = "categoryId") long categoryId) throws CategoryNotFoundException {
        CategoryRespone findCategory =  categoryService.findCategory(categoryId);
        return ResponseEntity.ok(findCategory);
    }

    @DeleteMapping("/deleted/{categoryId}")
    public ResponseEntity<CategoryRespone> deletedCategory(@PathVariable (value = "categoryId") long categoryId) throws CategoryDeleteException {
        CategoryRespone deletedCategory = categoryService.deletedCategory(categoryId);
        return ResponseEntity.ok(deletedCategory);
    }
}
