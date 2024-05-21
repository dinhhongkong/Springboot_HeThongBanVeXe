package com.example.sevicedatve.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity(name = "tinh_thanh_pho")
public class TinhThanhPho {
    @Id
    private int maTinh;

    @Column(name = "ten_tinh")
    private String tenTinh;

    @OneToMany(mappedBy = "tinhDi")
    private Set<ChuyenXe> listChuyenXeDi;

    @OneToMany(mappedBy = "tinhDen")
    private Set<ChuyenXe> listChuyenXeDen;

    public TinhThanhPho() {
    }

    public TinhThanhPho(int maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }

    public int getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public Set<ChuyenXe> getListChuyenXeDi() {
        return listChuyenXeDi;
    }

    public void setListChuyenXeDi(Set<ChuyenXe> listChuyenXeDi) {
        this.listChuyenXeDi = listChuyenXeDi;
    }

    public Set<ChuyenXe> getListChuyenXeDen() {
        return listChuyenXeDen;
    }

    public void setListChuyenXeDen(Set<ChuyenXe> listChuyenXeDen) {
        this.listChuyenXeDen = listChuyenXeDen;
    }
}
