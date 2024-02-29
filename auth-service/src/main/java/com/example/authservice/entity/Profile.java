package com.example.authservice.entity;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Profile() {
    }

    public Profile(long profileId, CommunicateInformation communicateInformation) {
        this.profileId = profileId;
        this.communicateInformation = communicateInformation;
    }
}
