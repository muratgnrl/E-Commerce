package com.example.transferservice.response;

import com.example.transferservice.dto.TransferDto;

import java.io.Serializable;

public class TransferResponse extends BaseResponse implements Serializable {
    public TransferDto transfer;
}
