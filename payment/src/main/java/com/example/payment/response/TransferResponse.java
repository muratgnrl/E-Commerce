package com.example.payment.response;

import com.example.payment.dto.TransferDto;

import java.io.Serializable;

public class TransferResponse extends BaseResponse implements Serializable {
    public TransferDto transferDto;
}
