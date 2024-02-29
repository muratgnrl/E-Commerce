package com.example.stockservice.repository;

import com.example.stockservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductId(long productId);
}
