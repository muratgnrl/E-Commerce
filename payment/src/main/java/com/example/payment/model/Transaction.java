package com.example.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private int cardNumber;
    private int cardCCV;
    private int expirationDate;
    private int userId;
    private int basketId;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public Transaction() {
    }

    public Transaction(int paymentId, int cardNumber, int cardCCV, int expirationDate, int userId, int basketId) {
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.cardCCV = cardCCV;
        this.expirationDate = expirationDate;
        this.userId = userId;
        this.basketId = basketId;
    }
}
