package com.example.authservice.service;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.exception.CommunicateInformationNotCreateException;
import com.example.authservice.exception.CommunicateInformationNotDeleted;
import com.example.authservice.response.CommunicateInformationResponse;

public interface CommunicateInformationService {
   CommunicateInformationResponse addCommunicateInformation(CommunicateInformationDto informationDto) throws CommunicateInformationNotCreateException;

    CommunicateInformationResponse deleteCommunicateInformation(long communicateInformationId) throws CommunicateInformationNotDeleted;
}
