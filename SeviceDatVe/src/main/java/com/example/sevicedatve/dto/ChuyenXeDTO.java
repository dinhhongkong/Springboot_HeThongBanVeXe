package com.example.sevicedatve.dto;

import com.example.sevicedatve.entity.QuanLy;
import com.example.sevicedatve.entity.TinhThanhPho;
import com.example.sevicedatve.entity.Xe;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ChuyenXeDTO {
    private int id;

    private Date thoiGianKhoiHanh;

    private double gia;

    private int idQuanLy;

    private String hoTenQuanLy;

    private int idXe;

    private int maTinhDi;

    private String tenTinhDi;

    private int maTinhDen;

    private String tenTinhDen;

    public ChuyenXeDTO() {
    }

    public ChuyenXeDTO(int id, Date thoiGianKhoiHanh, double gia, int idQuanLy, String hoTenQuanLy, int idXe, int maTinhDi, String tenTinhDi, int maTinhDen, String tenTinhDen) {
        this.id = id;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.gia = gia;
        this.idQuanLy = idQuanLy;
        this.hoTenQuanLy = hoTenQuanLy;
        this.idXe = idXe;
        this.maTinhDi = maTinhDi;
        this.tenTinhDi = tenTinhDi;
        this.maTinhDen = maTinhDen;
        this.tenTinhDen = tenTinhDen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public void setThoiGianKhoiHanh(Date thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
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

    public int getMaTinhDen() {
        return maTinhDen;
    }

    public void setMaTinhDen(int maTinhDen) {
        this.maTinhDen = maTinhDen;
    }

    public String getTenTinhDi() {
        return tenTinhDi;
    }

    public void setTenTinhDi(String tenTinhDi) {
        this.tenTinhDi = tenTinhDi;
    }

    public String getTenTinhDen() {
        return tenTinhDen;
    }

    public void setTenTinhDen(String tenTinhDen) {
        this.tenTinhDen = tenTinhDen;
    }
}
