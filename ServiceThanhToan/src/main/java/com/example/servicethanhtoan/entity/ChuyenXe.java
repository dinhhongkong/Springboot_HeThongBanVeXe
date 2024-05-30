package com.example.servicethanhtoan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "chuyen_xe")
public class ChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_khoi_hanh")
    private String ngayKhoiHanh;

    @Column(name = "gio_xuat_phat")
    private String gioXuatPhat;

    @OneToMany(mappedBy = "chuyenXe")
    private List<VeXe> listVeXe;
}
