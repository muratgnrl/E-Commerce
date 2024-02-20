package com.example.basket.repository;

import com.example.basket.model.Basket;
import com.example.basket.model.BasketDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketDetailsRepository extends JpaRepository<BasketDetails,Integer> {
    List<BasketDetails> findBasketDetailsByBasket(Basket basket);
}
