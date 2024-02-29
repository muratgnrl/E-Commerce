package com.example.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public long userId;
    public String userName;
    public String userLastName;
    public String password;
    public String mail;
    public long profileId;
    public ProfileDto profile;
    public CommunicateInformationDto communicateInformation;
    public long basketId;
}
