package com.example.basketservice.entity;

import jakarta.persistence.*;

@Entity
public class BasketDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long basketDetailsId;

    private int count;


    private long productId;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "basketId")
    private Basket basket;

    public long getBasketDetailsId() {
        return basketDetailsId;
    }

    public void setBasketDetailsId(long basketDetailsId) {
        this.basketDetailsId = basketDetailsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public BasketDetails(long basketDetailsId, int count, long productId, Basket basket) {
        this.basketDetailsId = basketDetailsId;
        this.count = count;
        this.productId = productId;
        this.basket = basket;
    }

    public BasketDetails() {
    }
}
