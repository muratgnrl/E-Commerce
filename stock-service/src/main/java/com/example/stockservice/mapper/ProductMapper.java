package com.example.stockservice.mapper;

import com.example.stockservice.dto.ProductDto;
import com.example.stockservice.model.Product;

public class ProductMapper {

    public static Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.productId);
        product.setProductAmount(productDto.productAmount);
        product.setProductName(productDto.productName);
        product.setProductDescription(productDto.productDescription);
        return product;
    }

    public static ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.productName = product.getProductName();
        productDto.productAmount = product.getProductAmount();
        productDto.productId = product.getProductId();
        productDto.productDescription = product.getProductDescription();

        return productDto;
    }
}
