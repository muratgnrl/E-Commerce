package com.example.authservice.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long profileId;

    @OneToOne
    private CommunicateInformation communicateInformation;

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public CommunicateInformation getCommunicateInformation() {
        return communicateInformation;
    }

    public void setCommunicateInformation(CommunicateInformation communicateInformation) {
        this.communicateInformation = communicateInformation;
    }

    public Profile(long profileId, CommunicateInformation communicateInformation) {
        this.profileId = profileId;
        this.communicateInformation = communicateInformation;
    }

    public Profile() {
    }


}
