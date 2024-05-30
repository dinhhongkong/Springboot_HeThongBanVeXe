package com.example.sevicedatve.dto;

import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.KhachHang;
import com.example.sevicedatve.entity.QuanLy;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class VeXeDTO {
    private String name;
    private String phone;
    private String email;

    public VeXeDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public VeXeDTO() {
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
}
