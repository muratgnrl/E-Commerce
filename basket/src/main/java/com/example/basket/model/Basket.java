package com.example.basket.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Basket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;
    private double totalAmount =0.0;
    private int status;
    private int userId;
    @OneToMany(mappedBy = "basket",fetch = FetchType.EAGER)
    List<BasketDetails> basketDetailsList;

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<BasketDetails> getBasketDetailsList() {
        return basketDetailsList;
    }

    public void setBasketDetailsList(List<BasketDetails> basketDetailsList) {
        this.basketDetailsList = basketDetailsList;
    }

    public Basket(int basketId, double totalAmount, int status, int userId, List<BasketDetails> basketDetailsList) {
        this.basketId = basketId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.userId = userId;
        this.basketDetailsList = basketDetailsList;
    }

    public Basket() {
    }
}
