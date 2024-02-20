package com.example.authservice.service;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.exception.CommunicateInformationDeletedException;
import com.example.authservice.exception.CommunicateInformationNotCreateException;
import com.example.authservice.response.CommunicateInformationResponse;
import org.springframework.stereotype.Service;


public interface CommunicateInformationService {
    CommunicateInformationResponse addCommunicateInformation(CommunicateInformationDto dto) throws CommunicateInformationNotCreateException;

    CommunicateInformationResponse deleteCommnicateInformation(long id) throws CommunicateInformationDeletedException;
}
