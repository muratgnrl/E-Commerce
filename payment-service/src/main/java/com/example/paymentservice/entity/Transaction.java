package com.example.paymentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private int cardNumber;
    private int cardCCV;
    private int expirationDate;
    private long userId;
    private long basketId;


    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardCCV() {
        return cardCCV;
    }

    public void setCardCCV(int cardCCV) {
        this.cardCCV = cardCCV;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public Transaction() {
    }

    public Transaction(long paymentId, int cardNumber, int cardCCV, int expirationDate, long userId, long basketId) {
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.cardCCV = cardCCV;
        this.expirationDate = expirationDate;
        this.userId = userId;
        this.basketId = basketId;
    }
}
