package com.example.transferservice.service;

import com.example.transferservice.dto.TransferDto;
import com.example.transferservice.exception.TransferException;
import com.example.transferservice.response.TransferResponse;

public interface TransferService {
    TransferResponse feedback(TransferDto transferDto) throws TransferException;
}
