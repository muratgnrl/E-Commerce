package com.example.stockservice.model;

import com.example.stockservice.dto.ProductDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "kategori")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Kategori_anahtarı",updatable = false, unique = true)
    private int categoryId;

    @Column(name = "Kategori_adı",unique = true)
    private String categoryName;

    @Column(name = "Kategori_açıklaması")
    private String categoryDescription;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Category() {
    }

    public Category(int categoryId, String categoryName, String categoryDescription, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.productList = productList;
    }
}
