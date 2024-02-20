package com.example.authservice.dto;

import com.example.authservice.model.CommunicateInformation;
import com.example.authservice.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    public long id;
    public String firstName;
    public String lastName;
    public String password;
    public String mail;
    public int profileId;
    public Profile profile;
    public int basketId;
    public CommunicateInformation communicateInformation;


}