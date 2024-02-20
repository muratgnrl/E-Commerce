package com.example.authservice.controller;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.exception.CommunicateInformationDeletedException;
import com.example.authservice.exception.CommunicateInformationNotCreateException;
import com.example.authservice.response.CommunicateInformationResponse;
import com.example.authservice.service.CommunicateInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communicateInformations")
public class CommunicateInformationController {

    private final CommunicateInformationService service;

    public CommunicateInformationController(CommunicateInformationService service) {
        this.service = service;
    }

    @PostMapping("/addCommunicateInformation")
    public ResponseEntity<CommunicateInformationResponse> addCommunicateInformation(@RequestBody CommunicateInformationDto dto) throws CommunicateInformationNotCreateException {
        CommunicateInformationResponse addCommunicateInformation = service.addCommunicateInformation(dto);
        return ResponseEntity.ok(addCommunicateInformation);
    }
    @DeleteMapping("/deleteCommunicateInformation/{id}")
    public ResponseEntity<CommunicateInformationResponse> deleteCommunicateInformation(@PathVariable (value = "id") long id) throws CommunicateInformationDeletedException {
        CommunicateInformationResponse deleteCommunicateInformation = service.deleteCommnicateInformation(id);
        return ResponseEntity.ok(deleteCommunicateInformation);
    }
}
