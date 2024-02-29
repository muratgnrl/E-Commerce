package com.example.authservice.controller;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.entity.CommunicateInformation;
import com.example.authservice.exception.CommunicateInformationNotCreateException;
import com.example.authservice.exception.CommunicateInformationNotDeleted;
import com.example.authservice.response.CommunicateInformationResponse;
import com.example.authservice.service.ımpl.CommunicateInformationServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communicateInformation")
public class CommunicateInformationController {

    private final CommunicateInformationServiceImpl communicateInformationService;

    public CommunicateInformationController(CommunicateInformationServiceImpl communicateInformationService) {
        this.communicateInformationService = communicateInformationService;
    }

    @PostMapping("/addCommunicateInformation")
    public ResponseEntity<CommunicateInformationResponse> addCommunicateInformation(@RequestBody CommunicateInformationDto informationDto) throws CommunicateInformationNotCreateException {
        CommunicateInformationResponse addInformation=communicateInformationService.addCommunicateInformation(informationDto);
        return ResponseEntity.ok(addInformation);
    }

    @DeleteMapping("/deleteCommunicateInformation/{communicateInformationId}")
    public ResponseEntity<CommunicateInformationResponse> deleteCommunicateInformation(@PathVariable (value = "communicateInformationId") long communicateInformationId) throws CommunicateInformationNotDeleted {
        CommunicateInformationResponse deleteCommunicateInformation= communicateInformationService.deleteCommunicateInformation(communicateInformationId);
        return ResponseEntity.ok(deleteCommunicateInformation);
    }
}
