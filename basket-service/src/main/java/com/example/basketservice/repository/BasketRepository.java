package com.example.basketservice.repository;

import com.example.basketservice.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    Basket findBasketsByUserIdAndStatus(long userId, int basketActivity);

    Basket findBasketByBasketId(long basketId);
}
