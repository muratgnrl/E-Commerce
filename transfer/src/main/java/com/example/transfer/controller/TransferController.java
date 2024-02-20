package com.example.transfer.controller;

import com.example.transfer.dto.TransferDto;
import com.example.transfer.response.TransferResponse;
import com.example.transfer.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping("/feedback")
    public TransferResponse feedback(@RequestBody TransferDto transferDto){
        return service.feedback(transferDto);
    }
}
