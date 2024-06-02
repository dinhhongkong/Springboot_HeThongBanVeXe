package com.example.servicequanly.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name= "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bien_so")
    private String bienSo;

    @Column(name = "tong_so_ghe")
    private int tongSoGhe;

    @Column(name = "loai_xe")
    private String loai_xe;

    @OneToMany(mappedBy = "xe")
    private Set<ChuyenXe> listChuyenXe;

    public Xe() {
    }

    public Xe(int id, String bienSo, int tongSoGhe, String loai_xe) {
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

    public Set<ChuyenXe> getListChuyenXe() {
        return listChuyenXe;
    }

    public void setListChuyenXe(Set<ChuyenXe> listChuyenXe) {
        this.listChuyenXe = listChuyenXe;
    }
}
