package com.example.servicequanly.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "tai_xe")
public class TaiXe {
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

    @Column(name = "loai_bang_lai")
    private String loaiBangLai;

    @OneToMany(mappedBy = "taiXe")
    private Set<ChiTietChuyenXe> listChiTietChuyenXe;

    public TaiXe() {
    }

    public TaiXe(int id, String hoTen, String ngaySinh, String soDienThoai, String queQuan, String loaiBangLai) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.queQuan = queQuan;
        this.loaiBangLai = loaiBangLai;
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

    public String getLoaiBangLai() {
        return loaiBangLai;
    }

    public void setLoaiBangLai(String loaiBangLai) {
        this.loaiBangLai = loaiBangLai;
    }

    public Set<ChiTietChuyenXe> getListChiTietChuyenXe() {
        return listChiTietChuyenXe;
    }

    public void setListChiTietChuyenXe(Set<ChiTietChuyenXe> listChiTietChuyenXe) {
        this.listChiTietChuyenXe = listChiTietChuyenXe;
    }
}
