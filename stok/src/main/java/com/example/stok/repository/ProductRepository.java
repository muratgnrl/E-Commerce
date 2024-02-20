package com.example.stok.repository;

import com.example.stok.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductByProductId(int productId);


}
