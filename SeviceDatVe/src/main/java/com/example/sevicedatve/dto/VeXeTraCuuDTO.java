package com.example.sevicedatve.dto;

import java.util.Date;

public class VeXeTraCuuDTO {
    private String name;
    private String phone;
    private String email;

    private String ngayKhoiHanh;

    private String gioXuatPhat;

    private String tinhXuatPhat;

    private String tinhDen;

    public VeXeTraCuuDTO() {
    }

    public VeXeTraCuuDTO(String name, String phone, String email, String ngayKhoiHanh, String gioXuatPhat, String tinhXuatPhat, String tinhDen) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioXuatPhat = gioXuatPhat;
        this.tinhXuatPhat = tinhXuatPhat;
        this.tinhDen = tinhDen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getGioXuatPhat() {
        return gioXuatPhat;
    }

    public void setGioXuatPhat(String gioXuatPhat) {
        this.gioXuatPhat = gioXuatPhat;
    }

    public String getTinhXuatPhat() {
        return tinhXuatPhat;
    }

    public void setTinhXuatPhat(String tinhXuatPhat) {
        this.tinhXuatPhat = tinhXuatPhat;
    }

    public String getTinhDen() {
        return tinhDen;
    }

    public void setTinhDen(String tinhDen) {
        this.tinhDen = tinhDen;
    }
}
