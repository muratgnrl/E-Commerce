package com.example.basket.model;

import com.example.basket.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDescription;
    private int productPrice;

    public static ProductDto toDto(Product product){
        ProductDto dto=new ProductDto();
        dto.productId=product.getProductId();
        dto.productAmount=product.getProductPrice();
        dto.productDescription=product.getProductDescription();
        dto.productName=product.getProductName();

        return dto;
    }

    public static Product toEntity(ProductDto dto){
        Product product=new Product();
        product.setProductId(dto.productId);
        product.setProductDescription(dto.productDescription);
        product.setProductPrice(dto.productAmount);
        product.setProductName(dto.productName);
        return product;
    }

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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productId, String productName, String productDescription, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public Product() {
    }
}
