package com.example.servicethanhtoan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "ve_xe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_dat")
    private String ngayDat;

    @Column(name = "trang_thai_thanh_toan")
    private boolean trangThaiThanhToan;

    private String transactionId;


}
