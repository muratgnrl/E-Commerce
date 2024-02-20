package com.example.basket.model;

import jakarta.persistence.*;

@Entity
public class BasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketProductId;
    private int count;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

    public BasketProduct(int basketProductId, int count, Product product, Basket basket) {
        this.basketProductId = basketProductId;
        this.count = count;
        this.product = product;
        this.basket = basket;
    }

    public BasketProduct() {
    }
}
