package com.example.sevicedatve.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class XeDTO {
    private int id;

    private String bienSo;

    private int tongSoGhe;

    private String loai_xe;

    public XeDTO() {
    }

    public XeDTO(int id, String bienSo, int tongSoGhe, String loai_xe) {
        this.id = id;
        this.bienSo = bienSo;
        this.tongSoGhe = tongSoGhe;
        this.loai_xe = loai_xe;
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

    public String getLoai_xe() {
        return loai_xe;
    }

    public void setLoai_xe(String loai_xe) {
        this.loai_xe = loai_xe;
    }
}
