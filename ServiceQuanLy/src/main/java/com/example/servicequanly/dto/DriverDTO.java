package com.example.servicequanly.dto;

import jakarta.persistence.Column;

public class DriverDTO {
    private int id;
    private String fullName;

    private String dateOfBirth;

    private String phoneNumber;

    private String queQuan;

    private String loaiBangLai;

    public DriverDTO() {
    }

    public DriverDTO(int id, String fullName, String dateOfBirth, String phoneNumber, String queQuan, String loaiBangLai) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.queQuan = queQuan;
        this.loaiBangLai = loaiBangLai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getLoaiBangLai() {
        return loaiBangLai;
    }

    public void setLoaiBangLai(String loaiBangLai) {
        this.loaiBangLai = loaiBangLai;
    }
}
