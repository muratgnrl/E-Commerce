package com.example.stockservice.service;

import com.example.stockservice.dto.ProductDto;
import com.example.stockservice.exception.ProductCreateException;
import com.example.stockservice.exception.ProductDeleteException;
import com.example.stockservice.exception.ProductNotFoundException;
import com.example.stockservice.response.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductDto productDto) throws ProductCreateException;

    ProductResponse getProduct(long productId) throws ProductNotFoundException;

    ProductResponse deleted(long productId) throws ProductDeleteException;
}
