package com.example.stockservice.controller;

import com.example.stockservice.dto.ProductDto;
import com.example.stockservice.exception.ProductCreateException;
import com.example.stockservice.exception.ProductDeleteException;
import com.example.stockservice.exception.ProductNotFoundException;
import com.example.stockservice.response.ProductResponse;
import com.example.stockservice.service.ımpl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductDto productDto) throws ProductCreateException {
        ProductResponse addProduct = productService.addProduct(productDto);
        return ResponseEntity.ok(addProduct);
    }
    @GetMapping("/findProduct/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable (value = "productId") long productId) throws ProductNotFoundException {
        ProductResponse getProduct =productService.getProduct(productId);
        return ResponseEntity.ok(getProduct);
    }
    @DeleteMapping("/deletedproduct/{productId}")
    public ResponseEntity<ProductResponse> deleted (@PathVariable (value = "productId") long productId) throws ProductDeleteException {
        ProductResponse deleted = productService.deleted(productId);
        return ResponseEntity.ok(deleted);
    }
}
