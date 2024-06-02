package com.example.servicequanly.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyChiTietChuyenXe implements Serializable {
    @Column(name = "id_tai_xe")
    private int idTaiXe;

    @Column(name = "id_chuyen_xe")
    private int idChuyenXe;

    public KeyChiTietChuyenXe() {
    }

    public KeyChiTietChuyenXe(int idTaiXe, int idChuyenXe) {
        this.idTaiXe = idTaiXe;
        this.idChuyenXe = idChuyenXe;
    }

    public int getIdTaiXe() {
        return idTaiXe;
    }

    public void setIdTaiXe(int idTaiXe) {
        this.idTaiXe = idTaiXe;
    }

    public int getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(int idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }
}
