package com.example.authservice.dto;

import com.example.authservice.model.CommunicateInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto implements Serializable {
    private long profileId;
    private long communicateInformationId;
}
