package com.example.stok.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;


@RedisHash("kategori")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @Column(name = "Kategori_adı",unique = true)
    private String categoryName;

    @Column(name = "Kategori_açıklaması")
    private String categoryDescription;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;


    public Category() {
    }

    public Category(int categoryId, String categoryName, String categoryDescription, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.productList = productList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
