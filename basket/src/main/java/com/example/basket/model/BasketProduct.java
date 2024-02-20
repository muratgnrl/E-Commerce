package com.example.basket.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class BasketProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketProductId;
    private int count;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Product product;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "basketId")
    private Basket basket;

    public int getBasketProductId() {
        return basketProductId;
    }

    public void setBasketProductId(int basketProductId) {
        this.basketProductId = basketProductId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public BasketProduct() {
    }

    public BasketProduct(int basketProductId, int count, Product product, Basket basket) {
        this.basketProductId = basketProductId;
        this.count = count;
        this.product = product;
        this.basket = basket;
    }
}
