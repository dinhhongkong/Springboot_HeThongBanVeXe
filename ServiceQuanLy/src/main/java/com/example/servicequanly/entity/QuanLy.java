package com.example.servicequanly.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "quan_ly")
public class QuanLy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "que_quan")
    private String queQuan;

    @OneToMany(mappedBy = "quanLy")
    private Set<ChuyenXe> listChuyenXe;

//    @OneToMany(mappedBy = "quanLy")
//    private Set<VeXe> listVeXe;

    public QuanLy() {
    }

    public QuanLy(int id, String hoTen, String ngaySinh, String soDienThoai, String queQuan) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.queQuan = queQuan;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Set<ChuyenXe> getListChuyenXe() {
        return listChuyenXe;
    }

    public void setListChuyenXe(Set<ChuyenXe> listChuyenXe) {
        this.listChuyenXe = listChuyenXe;
    }

//    public Set<VeXe> getListVeXe() {
//        return listVeXe;
//    }
//
//    public void setListVeXe(Set<VeXe> listVeXe) {
//        this.listVeXe = listVeXe;
//    }
}
