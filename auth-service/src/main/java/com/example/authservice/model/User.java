package com.example.authservice.model;

import jakarta.persistence.*;
import lombok.Builder;


import java.io.Serializable;

@Builder
@Table(name = "Kullanıcı")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "kullanıcı_ismi",nullable = false)
    private String firstName;
    @Column(name = "kullanıcı_soyismi",nullable = false)
    private String lastName;
    @Column(name = "kullanıcı_mail",nullable = false,unique = true)
    private String mail;
    @Column(name = "kullanıcı_sifre",nullable = false)
    private String password;
    @OneToOne
    private Profile profile;
    @OneToOne
    private CommunicateInformation communicateInformation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public User(long id, String firstName, String lastName, String mail, String password, Profile profile, CommunicateInformation communicateInformation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.profile = profile;
        this.communicateInformation = communicateInformation;
    }

    public User() {
    }
}
