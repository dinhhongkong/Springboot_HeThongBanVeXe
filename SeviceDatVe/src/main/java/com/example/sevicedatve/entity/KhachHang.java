package com.example.sevicedatve.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

//    Chua tao entity tai khoan
//    @ManyToOne
//    @JoinColumn(name = "username")
//    private

    @OneToMany(mappedBy = "khachHang")
    private Set<VeXe> listVeXe;


    public KhachHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<VeXe> getListVeXe() {
        return listVeXe;
    }

    public void setListVeXe(Set<VeXe> listVeXe) {
        this.listVeXe = listVeXe;
    }
}
