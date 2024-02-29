package com.example.authservice.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String userLastName;
    @Column(nullable = false,unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;
    @OneToOne
    private Profile profile;
    @OneToOne
    CommunicateInformation communicateInformation;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public CommunicateInformation getCommunicateInformation() {
        return communicateInformation;
    }

    public void setCommunicateInformation(CommunicateInformation communicateInformation) {
        this.communicateInformation = communicateInformation;
    }

    public User() {
    }

    public User(long userId, String userName, String userLastName, String mail, String password, Profile profile, CommunicateInformation communicateInformation) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.mail = mail;
        this.password = password;
        this.profile = profile;
        this.communicateInformation = communicateInformation;
    }
}
