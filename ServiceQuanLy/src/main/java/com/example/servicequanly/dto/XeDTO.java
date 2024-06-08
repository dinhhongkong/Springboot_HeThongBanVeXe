package com.example.servicequanly.dto;

import lombok.Builder;

@Builder
public class XeDTO {
    private int id;

    private String bienSo;

    private int tongSoGhe;

    private String loaiXe;

    public XeDTO() {
    }

    public XeDTO(int id, String bienSo, int tongSoGhe, String loaiXe) {
        this.id = id;
        this.bienSo = bienSo;
        this.tongSoGhe = tongSoGhe;
        this.loaiXe = loaiXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public int getTongSoGhe() {
        return tongSoGhe;
    }

    public void setTongSoGhe(int tongSoGhe) {
        this.tongSoGhe = tongSoGhe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }
}
