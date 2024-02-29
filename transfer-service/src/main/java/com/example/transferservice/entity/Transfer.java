package com.example.transferservice.entity;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Transfer implements Serializable {
    private long transferId;
    private String transferDesc;
    private long basketId;
    private boolean status;

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public String getTransferDesc() {
        return transferDesc;
    }

    public void setTransferDesc(String transferDesc) {
        this.transferDesc = transferDesc;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Transfer() {
    }

    public Transfer(long transferId, String transferDesc, long basketId, boolean status) {
        this.transferId = transferId;
        this.transferDesc = transferDesc;
        this.basketId = basketId;
        this.status = status;
    }
}
