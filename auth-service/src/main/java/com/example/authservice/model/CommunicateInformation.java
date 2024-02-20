package com.example.authservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "iletisim_bilgileri")
public class CommunicateInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "adres", nullable = false)
    private String adress;
    @Column(name = "telefon_numarası")
    private String telephonNumber;
    @Column(name = "dogum_tarihi")
    private String birthDay;
    @OneToOne
    private User user;

    public CommunicateInformation() {
    }

    public CommunicateInformation(long id, String adress, String telephonNumber, String birthDay, User user) {
        this.id = id;
        this.adress = adress;
        this.telephonNumber = telephonNumber;
        this.birthDay = birthDay;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}