package com.example.stok.exception;

import com.example.stok.response.CategoryResponse;
import com.example.stok.response.Meta;
import com.example.stok.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> createNot(CategoryNotCreateException createException, WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse response=new CategoryResponse();

        meta.errorCode=4004;
        meta.errorDescription="Kategori kayıt başarısız";
        response.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> notFoundCategory(CategoryNotFoundException categoryNotFoundException, WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse response=new CategoryResponse();

        meta.errorCode=4004;
        meta.errorDescription="Kategori bulunamadı";
        response.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteCategory(CategoryDeleteException categoryDeleteException, WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse response=new CategoryResponse();

        meta.errorCode=4004;
        meta.errorDescription="Kategori silinemedi";
        response.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productFindException(ProductFindException productFindException, WebRequest webRequest){
        Meta meta=new Meta();
        ProductResponse response=new ProductResponse();

        meta.errorCode=4004;
        meta.errorDescription="Ürün bulunamadı";
        response.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productAddException(ProductNotAddException productNotAddException, WebRequest webRequest){
        Meta meta=new Meta();
        ProductResponse response=new ProductResponse();

        meta.errorCode=4004;
        meta.errorDescription="Ürün eklenmedi";
        response.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productDelete(ProductDeleteException productDeleteException, WebRequest webRequest){
        Meta meta=new Meta();
        ProductResponse response=new ProductResponse();

        meta.errorCode=4004;
        meta.errorDescription="Ürün Silinemedi";
        response.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return entity;
    }
}
