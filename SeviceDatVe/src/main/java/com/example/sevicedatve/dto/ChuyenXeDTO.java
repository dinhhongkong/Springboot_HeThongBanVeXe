package com.example.sevicedatve.dto;

import com.example.sevicedatve.entity.*;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Component
public class ChuyenXeDTO {
    private int id;

    private String ngayKhoiHanh;

    private String gioXuatPhat;

    private float thoiGianDuKien;

    private double gia;

    private int idQuanLy;

    private String hoTenQuanLy;

    private int idXe;

    private String loaiXe;

    private int choTrong;

    private int maTinhDi;

    private String tenTinhDi;

    private int maTinhDen;

    private String tenTinhDen;

    private Set<VeXe> listVeXe;

    // List Ve Da Dat
    private Set<String> listMaGhe;

    public ChuyenXeDTO() {
    }

    public ChuyenXeDTO(int id, String ngayKhoiHanh, String gioXuatPhat, float thoiGianDuKien, double gia, int idQuanLy, String hoTenQuanLy, int idXe, String loaiXe, int choTrong, int maTinhDi, String tenTinhDi, int maTinhDen, String tenTinhDen, Set<VeXe> listVeXe, Set<String> listMaGhe) {
        this.id = id;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioXuatPhat = gioXuatPhat;
        this.thoiGianDuKien = thoiGianDuKien;
        this.gia = gia;
        this.idQuanLy = idQuanLy;
        this.hoTenQuanLy = hoTenQuanLy;
        this.idXe = idXe;
        this.loaiXe = loaiXe;
        this.choTrong = choTrong;
        this.maTinhDi = maTinhDi;
        this.tenTinhDi = tenTinhDi;
        this.maTinhDen = maTinhDen;
        this.tenTinhDen = tenTinhDen;
        this.listVeXe = listVeXe;
        this.listMaGhe = listMaGhe;
    }

    public int getChoTrong() {
        return choTrong;
    }

    public void setChoTrong(int choTrong) {
        this.choTrong = choTrong;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getIdQuanLy() {
        return idQuanLy;
    }

    public void setIdQuanLy(int idQuanLy) {
        this.idQuanLy = idQuanLy;
    }

    public String getHoTenQuanLy() {
        return hoTenQuanLy;
    }

    public void setHoTenQuanLy(String hoTenQuanLy) {
        this.hoTenQuanLy = hoTenQuanLy;
    }

    public int getIdXe() {
        return idXe;
    }

    public void setIdXe(int idXe) {
        this.idXe = idXe;
    }

    public int getMaTinhDi() {
        return maTinhDi;
    }

    public void setMaTinhDi(int maTinhDi) {
        this.maTinhDi = maTinhDi;
    }

    public String getTenTinhDi() {
        return tenTinhDi;
    }

    public void setTenTinhDi(String tenTinhDi) {
        this.tenTinhDi = tenTinhDi;
    }

    public int getMaTinhDen() {
        return maTinhDen;
    }

    public void setMaTinhDen(int maTinhDen) {
        this.maTinhDen = maTinhDen;
    }

    public String getTenTinhDen() {
        return tenTinhDen;
    }

    public void setTenTinhDen(String tenTinhDen) {
        this.tenTinhDen = tenTinhDen;
    }

    public Set<VeXe> getListVeXe() {
        return listVeXe;
    }

    public void setListVeXe(Set<VeXe> listVeXe) {
        this.listVeXe = listVeXe;
    }

    public Set<String> getListMaGhe() {
        return listMaGhe;
    }

    public void setListMaGhe(Set<String> listMaGhe) {
        this.listMaGhe = listMaGhe;
    }
}
