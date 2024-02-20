package com.example.basket.model;

import com.example.basket.dto.ProductDto;
import jakarta.persistence.Entity;

@Entity
public class Product {

    private int productId;
    private String productDescription;
    private String productName;
    private int productPrice;



    public static ProductDto toDto(Product product){
        ProductDto dto=new ProductDto();
        dto.productId=product.getProductId();
        dto.productAmount=product.getProductPrice();
        dto.productDescription=product.getProductDescription();
        dto.productName=product.getProductName();

        return dto;
    }
    public static  Product toEntity(ProductDto productDto){
        Product product=new Product();
        product.setProductId(productDto.productId);
        product.setProductName(productDto.productName);
        product.setProductPrice(productDto.productAmount);
        product.setProductDescription(productDto.productDescription);
        return product;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productId, String productDescription, String productName, int productPrice) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product() {
    }
}
