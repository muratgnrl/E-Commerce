package com.example.authservice.entity;

import jakarta.persistence.*;

@Entity
public class CommunicateInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long communicateInformationId;
    private String adress;
    @Column(unique = true)
    private String telephonNumber;
    private String birthDay;
    @OneToOne
    private User user;

    public long getCommunicateInformationId() {
        return communicateInformationId;
    }

    public void setCommunicateInformationId(long communicateInformationId) {
        this.communicateInformationId = communicateInformationId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephonNumber() {
        return telephonNumber;
    }

    public void setTelephonNumber(String telephonNumber) {
        this.telephonNumber = telephonNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CommunicateInformation() {
    }

    public CommunicateInformation(long communicateInformationId, String adress, String telephonNumber, String birthDay, User user) {
        this.communicateInformationId = communicateInformationId;
        this.adress = adress;
        this.telephonNumber = telephonNumber;
        this.birthDay = birthDay;
        this.user = user;
    }
}
