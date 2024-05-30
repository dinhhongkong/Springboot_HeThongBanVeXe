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
    private int trangThaiThanhToan;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "sdt_kh")
    private String phoneNumber;

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_chuyen_xe")
    private ChuyenXe chuyenXe;


}
