package com.example.sevicedatve.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "chuyen_xe")
public class ChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_khoi_hanh")
    private String ngayKhoiHanh;

    @Column(name = "gio_xuat_phat")
    private String gioXuatPhat;

    @Column(name = "thoi_gian_du_kien")
    private float thoiGianDuKien;

    @Column(name = "gia")
    private double gia;

    @ManyToOne
    @JoinColumn(name = "id_quan_ly")
    private QuanLy quanLy;

    @ManyToOne
    @JoinColumn(name = "id_xe")
    private Xe xe;

    @ManyToOne
    @JoinColumn(name = "ma_tinh_di")
    private TinhThanhPho tinhDi;

    @ManyToOne
    @JoinColumn(name = "ma_tinh_den")
    private TinhThanhPho tinhDen;

    @OneToMany(mappedBy = "chuyenXe")
    private Set<ChiTietChuyenXe> listChiTietChuyenXe;

    @OneToMany(mappedBy = "chuyenXe")
    private Set<VeXe> listVeXe;

    public ChuyenXe() {
    }

    public ChuyenXe(int id, String ngayKhoiHanh, double gia, QuanLy quanLy, Xe xe, TinhThanhPho tinhDi, TinhThanhPho tinhDen) {
        this.id = id;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gia = gia;
        this.quanLy = quanLy;
        this.xe = xe;
        this.tinhDi = tinhDi;
        this.tinhDen = tinhDen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public QuanLy getQuanLy() {
        return quanLy;
    }

    public void setQuanLy(QuanLy quanLy) {
        this.quanLy = quanLy;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public TinhThanhPho getTinhDi() {
        return tinhDi;
    }

    public void setTinhDi(TinhThanhPho tinhDi) {
        this.tinhDi = tinhDi;
    }

    public TinhThanhPho getTinhDen() {
        return tinhDen;
    }

    public void setTinhDen(TinhThanhPho tinhDen) {
        this.tinhDen = tinhDen;
    }

    public Set<ChiTietChuyenXe> getListChiTietChuyenXe() {
        return listChiTietChuyenXe;
    }

    public void setListChiTietChuyenXe(Set<ChiTietChuyenXe> listChiTietChuyenXe) {
        this.listChiTietChuyenXe = listChiTietChuyenXe;
    }

    public Set<VeXe> getListVeXe() {
        return listVeXe;
    }

    public void setListVeXe(Set<VeXe> listVeXe) {
        this.listVeXe = listVeXe;
    }

    public String getGioXuatPhat() {
        return gioXuatPhat;
    }

    public void setGioXuatPhat(String gioXuatPhat) {
        this.gioXuatPhat = gioXuatPhat;
    }

    public float getThoiGianDuKien() {
        return thoiGianDuKien;
    }

    public void setThoiGianDuKien(float thoiGianDuKien) {
        this.thoiGianDuKien = thoiGianDuKien;
    }
}
