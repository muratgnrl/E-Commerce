package com.example.authservice.response;

import com.example.authservice.dto.CommunicateInformationDto;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class CommunicateInformationResponse extends BaseResponse implements Serializable {

    public CommunicateInformationDto communicateInformationDto;
}
