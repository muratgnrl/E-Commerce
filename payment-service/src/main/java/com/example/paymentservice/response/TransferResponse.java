package com.example.paymentservice.response;

import com.example.paymentservice.dto.TransferDto;

import java.io.Serializable;

public class TransferResponse extends BaseResponse implements Serializable {
    public TransferDto transfer;
}
