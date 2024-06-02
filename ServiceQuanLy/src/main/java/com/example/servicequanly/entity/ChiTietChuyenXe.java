package com.example.servicequanly.entity;

import com.example.servicequanly.entity.keys.KeyChiTietChuyenXe;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "chi_tiet_chuyen_xe")
public class ChiTietChuyenXe {

    @EmbeddedId
    private KeyChiTietChuyenXe keyChiTietChuyenXe;

    @ManyToOne
    @JoinColumn(name = "id_tai_xe", insertable = false, updatable = false)
    private TaiXe taiXe;

    @ManyToOne
    @JoinColumn(name = "id_chuyen_xe", insertable = false, updatable = false)
    private ChuyenXe chuyenXe;

    public ChiTietChuyenXe() {
    }

    public ChiTietChuyenXe(KeyChiTietChuyenXe keyChiTietChuyenXe) {
        this.keyChiTietChuyenXe = keyChiTietChuyenXe;
    }

    public KeyChiTietChuyenXe getKeyChiTietChuyenXe() {
        return keyChiTietChuyenXe;
    }

    public void setKeyChiTietChuyenXe(KeyChiTietChuyenXe keyChiTietChuyenXe) {
        this.keyChiTietChuyenXe = keyChiTietChuyenXe;
    }
}
