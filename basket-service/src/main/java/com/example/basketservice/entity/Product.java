package com.example.basketservice.entity;

import com.example.basketservice.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private String productDescription;
    private int productPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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

    public static Product mapToEntity(ProductDto productDto){
        Product product =new Product();
        product.setProductId(productDto.productId);
        product.setProductName(productDto.productName);
        product.setProductDescription(productDto.productDescprition);
        product.setProductPrice(productDto.productAmount);
        return product;
    }
    public static  ProductDto mapToDto(Product product){
        ProductDto productDto =new ProductDto();
        productDto.productAmount= product.getProductPrice();
        productDto.productId=product.getProductId();
        productDto.productDescprition=product.getProductDescription();
        productDto.productName=product.getProductName();
        return productDto;
    }

}
