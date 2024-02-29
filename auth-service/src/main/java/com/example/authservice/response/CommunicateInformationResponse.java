package com.example.authservice.response;

import com.example.authservice.dto.CommunicateInformationDto;

import java.io.Serializable;

public class CommunicateInformationResponse extends BaseResponse implements Serializable {
    public CommunicateInformationDto communicateInformationDto;
}
