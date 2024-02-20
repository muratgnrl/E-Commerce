package com.example.basket.repository;

import com.example.basket.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
    Basket findBasketsByUserIdAndStatus(int userId, int i);

    Basket findBasketByBasketId(int basketId);
}
