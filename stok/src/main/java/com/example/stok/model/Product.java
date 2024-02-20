package com.example.stok.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;



@RedisHash("product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "Ürün_adı", nullable = false, unique = true)
    private String productName;

    @Column(name = "Ürün_açıklaması", nullable = false)
    private String productDescprition;

    @Column(name = "Ürün_fiyatı", nullable = false)
    private int productAmount;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescprition() {
        return productDescprition;
    }

    public void setProductDescprition(String productDescprition) {
        this.productDescprition = productDescprition;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(int productId, String productName, String productDescprition, int productAmount, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productDescprition = productDescprition;
        this.productAmount = productAmount;
        this.category = category;
    }

    public Product() {
    }
}