package com.example.sevicedatve.dto;

import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.KhachHang;
import com.example.sevicedatve.entity.QuanLy;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class VeXeDTO {
    private int id;

    private Date ngayDat;

    private boolean trangThaiThanhToan;

    private String maGhe;

    private int idKhachHang;
    private String tenKhachHang;
    private String soDienThoaiKhachHang;

    private int idChuyenXe;

    private int idQuanLy;

    private String tenQuanLy;

    public VeXeDTO() {
    }

    public VeXeDTO(int id, Date ngayDat, boolean trangThaiThanhToan, String maGhe, int idKhachHang, String tenKhachHang, String soDienThoaiKhachHang, int idChuyenXe, int idQuanLy, String tenQuanLy) {
        this.id = id;
        this.ngayDat = ngayDat;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maGhe = maGhe;
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoaiKhachHang = soDienThoaiKhachHang;
        this.idChuyenXe = idChuyenXe;
        this.idQuanLy = idQuanLy;
        this.tenQuanLy = tenQuanLy;
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

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoaiKhachHang() {
        return soDienThoaiKhachHang;
    }

    public void setSoDienThoaiKhachHang(String soDienThoaiKhachHang) {
        this.soDienThoaiKhachHang = soDienThoaiKhachHang;
    }

    public int getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(int idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public int getIdQuanLy() {
        return idQuanLy;
    }

    public void setIdQuanLy(int idQuanLy) {
        this.idQuanLy = idQuanLy;
    }

    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }
}
