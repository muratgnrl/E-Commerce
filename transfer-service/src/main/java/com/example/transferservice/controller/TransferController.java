package com.example.transferservice.controller;

import com.example.transferservice.dto.TransferDto;
import com.example.transferservice.exception.TransferException;
import com.example.transferservice.response.TransferResponse;
import com.example.transferservice.service.ımpl.TransferServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final TransferServiceImpl transferService;

    public TransferController(TransferServiceImpl transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<TransferResponse> feedback(@RequestBody TransferDto transferDto) throws TransferException {
        TransferResponse feedback =transferService.feedback(transferDto);
        return ResponseEntity.ok(feedback);
    }
}
