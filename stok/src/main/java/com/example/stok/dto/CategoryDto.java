package com.example.stok.dto;

import com.example.stok.model.Category;
import com.example.stok.model.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class CategoryDto implements Serializable {

    public int categoryId;
    public String categoryName;
    public String categoryDescription;
    public List<Product> productList;


    public static Category toEntity(CategoryDto categoryDto){
        Category category=new Category();
        category.setCategoryName(categoryDto.categoryName);
        category.setCategoryDescription(categoryDto.categoryDescription);
        category.setCategoryId(categoryDto.categoryId);
        category.setProductList(categoryDto.productList);
        return category;
    }
    public static CategoryDto toResource(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.categoryId = category.getCategoryId();
        categoryDto.categoryDescription = category.getCategoryDescription();
        categoryDto.categoryName = category.getCategoryName();
        categoryDto.productList = category.getProductList();
        return categoryDto;
    }
}
