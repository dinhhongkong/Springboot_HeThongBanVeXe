package com.example.sevicedatve.entity;

import jakarta.persistence.*;

import java.sql.Struct;
import java.util.Date;

@Entity(name = "ve_xe")
public class VeXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_dat")
    private Date ngayDat;

    @Column(name = "trang_thai_thanh_toan")
    private boolean trangThaiThanhToan;

    @Column(name = "ma_ghe")
    private String maGhe;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_chuyen_xe")
    private ChuyenXe chuyenXe;

    @ManyToOne
    @JoinColumn(name = "id_quan_ly")
    private QuanLy quanLy;

    @Column(name = "ho_ten_kh")
    private String hoTenKH;

    @Column(name = "sdt_kh")
    private String phoneKH;

    @Column(name = "email_kh")
    private String emailKH;

    public VeXe() {
    }

    public VeXe(int id, Date ngayDat, boolean trangThaiThanhToan, String maGhe, KhachHang khachHang, ChuyenXe chuyenXe, QuanLy quanLy, String hoTenKH, String phoneKH, String emailKH) {
        this.id = id;
        this.ngayDat = ngayDat;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maGhe = maGhe;
        this.khachHang = khachHang;
        this.chuyenXe = chuyenXe;
        this.quanLy = quanLy;
        this.hoTenKH = hoTenKH;
        this.phoneKH = phoneKH;
        this.emailKH = emailKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public boolean isTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public ChuyenXe getChuyenXe() {
        return chuyenXe;
    }

    public void setChuyenXe(ChuyenXe chuyenXe) {
        this.chuyenXe = chuyenXe;
    }

    public QuanLy getQuanLy() {
        return quanLy;
    }

    public void setQuanLy(QuanLy quanLy) {
        this.quanLy = quanLy;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getPhoneKH() {
        return phoneKH;
    }

    public void setPhoneKH(String phoneKH) {
        this.phoneKH = phoneKH;
    }

    public String getEmailKH() {
        return emailKH;
    }

    public void setEmailKH(String emailKH) {
        this.emailKH = emailKH;
    }
}
