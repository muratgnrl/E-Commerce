package com.example.basket.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class BasketDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketDetailsId;

    private int count;


    private int productId;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "basketId")
    private Basket basket;


    public int getBasketDetailsId() {
        return basketDetailsId;
    }

    public void setBasketDetailsId(int basketDetailsId) {
        this.basketDetailsId = basketDetailsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public BasketDetails() {
    }

    public BasketDetails(int basketDetailsId, int count, int productId, Basket basket) {
        this.basketDetailsId = basketDetailsId;
        this.count = count;
        this.productId = productId;
        this.basket = basket;
    }
}
