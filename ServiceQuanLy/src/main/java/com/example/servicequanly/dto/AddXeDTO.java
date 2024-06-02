package com.example.servicequanly.dto;

public class AddXeDTO {
    private String bienSo;

    private int tongSoGhe;

    private String loaiXe;

    public AddXeDTO() {
    }

    public AddXeDTO(String bienSo, int tongSoGhe, String loaiXe) {
        this.bienSo = bienSo;
        this.tongSoGhe = tongSoGhe;
        this.loaiXe = loaiXe;
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
