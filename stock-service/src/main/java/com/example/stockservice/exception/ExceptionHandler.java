package com.example.stockservice.exception;

import com.example.stockservice.response.CategoryRespone;
import com.example.stockservice.response.Meta;
import com.example.stockservice.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> createNotException(CategoryNotCreate categoryNotCreate, WebRequest webRequest) {
        CategoryRespone categoryRespone = new CategoryRespone();
        categoryRespone.meta = new Meta(4004, "Category Oluşturulamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(categoryRespone, HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deletedCategory(CategoryDeleteException categoryDeleteException, WebRequest webRequest) {
        CategoryRespone categoryRespone = new CategoryRespone();
        categoryRespone.meta = new Meta(4004, "Category Silinemedi");
        ResponseEntity<Object> entity = new ResponseEntity<>(categoryRespone, HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> categoryNotFoundException(CategoryNotFoundException categoryNotFoundException, WebRequest webRequest) {
        CategoryRespone categoryRespone = new CategoryRespone();
        categoryRespone.meta = new Meta(4004, "Category bulunamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(categoryRespone, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> categoryGetAllException(CategoryGetAllException categoryGetAllException, WebRequest webRequest) {
        CategoryRespone categoryRespone = new CategoryRespone();
        categoryRespone.meta = new Meta(4004, "Tüm kategoriler bulunamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(categoryRespone, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productCreateException(ProductCreateException productCreateException, WebRequest webRequest) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.meta = new Meta(4004, "Ürün oluşturulamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(productResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productNotFoundException(ProductNotFoundException productNotFoundException, WebRequest webRequest) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.meta = new Meta(4004, "Ürün bulunamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(productResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productDeleteException(ProductDeleteException productDeleteException, WebRequest webRequest) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.meta = new Meta(4004, "Ürün silinemedi ıd bulunamadı");
        ResponseEntity<Object> entity = new ResponseEntity<>(productResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
