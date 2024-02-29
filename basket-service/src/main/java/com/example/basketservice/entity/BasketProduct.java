package com.example.basketservice.entity;

import jakarta.persistence.*;

@Entity
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long basketProductId;

    private int count;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "basketId")
    private Basket basket;

    public long getBasketProductId() {
        return basketProductId;
    }

    public void setBasketProductId(long basketProductId) {
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

    public BasketProduct(long basketProductId, int count, Product product, Basket basket) {
        this.basketProductId = basketProductId;
        this.count = count;
        this.product = product;
        this.basket = basket;
    }

    public BasketProduct() {
    }
}
