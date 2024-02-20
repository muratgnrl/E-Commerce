package com.example.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicateInformationDto implements Serializable {
    private long id;
    private String adress;
    private String telephonNumber;
    private String birthDay;
    private long userId;
}
