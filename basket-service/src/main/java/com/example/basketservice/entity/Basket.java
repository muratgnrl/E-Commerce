package com.example.basketservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Basket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long basketId;

    private double totalAmount= 0.0;

    private int status;

    private long userId;
    @OneToMany(mappedBy = "basket", fetch = FetchType.EAGER)
    List<BasketDetails> basketDetailList;

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<BasketDetails> getBasketDetailList() {
        return basketDetailList;
    }

    public void setBasketDetailList(List<BasketDetails> basketDetailList) {
        this.basketDetailList = basketDetailList;
    }

    public Basket(long basketId, double totalAmount, int status, long userId, List<BasketDetails> basketDetailList) {
        this.basketId = basketId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.userId = userId;
        this.basketDetailList = basketDetailList;
    }

    public Basket() {
    }
}
