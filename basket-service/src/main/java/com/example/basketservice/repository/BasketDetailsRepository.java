package com.example.basketservice.repository;

import com.example.basketservice.entity.Basket;
import com.example.basketservice.entity.BasketDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketDetailsRepository extends JpaRepository<BasketDetails,Long> {
    List<BasketDetails> findBasketDetailsByBasket(Basket basket);
}
