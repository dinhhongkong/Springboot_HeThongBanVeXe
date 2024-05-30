package com.example.sevicedatve.dto;

import java.util.Date;
import java.util.List;

public class VeXeRequestDTO {

    private Date ngayDat;

    private boolean trangThaiThanhToan;

    private List<String> listSeat;

    private int idKhachHang;

    private int idChuyenXe;

    private int idQuanLy;

    private String name;
    private String phone;

    private String email;

    public VeXeRequestDTO() {
    }

    public VeXeRequestDTO(Date ngayDat, boolean trangThaiThanhToan, List<String> listSeat, int idKhachHang, int idChuyenXe, int idQuanLy, String name, String phone, String email) {
        this.ngayDat = ngayDat;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.listSeat = listSeat;
        this.idKhachHang = idKhachHang;
        this.idChuyenXe = idChuyenXe;
        this.idQuanLy = idQuanLy;
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public List<String> getListSeat() {
        return listSeat;
    }

    public void setListSeat(List<String> listSeat) {
        this.listSeat = listSeat;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
