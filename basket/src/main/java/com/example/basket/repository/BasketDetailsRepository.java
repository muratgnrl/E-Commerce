package com.example.basket.repository;

import com.example.basket.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketDetailsRepository extends JpaRepository<Basket,Integer> {
}
