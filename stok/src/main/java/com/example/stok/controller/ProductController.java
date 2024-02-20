package com.example.stok.controller;


import com.example.stok.dto.ProductDto;
import com.example.stok.exception.ProductDeleteException;
import com.example.stok.exception.ProductFindException;
import com.example.stok.exception.ProductNotAddException;
import com.example.stok.response.ProductResponse;
import com.example.stok.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductDto productDto) throws ProductNotAddException {
        ProductResponse response=service.createProduct(productDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findProduct/{productId}")
    public ResponseEntity<ProductResponse> findProduct(@PathVariable(value = "productId") int productId) throws ProductFindException {
        ProductResponse response=service.findProduct(productId);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getAllProducts")
    private ResponseEntity<List<ProductDto>> productDtoList(){
        List<ProductDto> productDtoList=service.productDtoList();
        return ResponseEntity.ok(productDtoList);
    }
    @DeleteMapping("/delete/{productId}")
    private ResponseEntity<ProductResponse> deleteProduct(@PathVariable (value = "productId") int productId) throws ProductDeleteException {
        ProductResponse response=service.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto ,@PathVariable (value = "productId") int productId){
        ProductDto updated=service.updateProduct(productDto,productId);
        return ResponseEntity.ok(updated);
    }
}
