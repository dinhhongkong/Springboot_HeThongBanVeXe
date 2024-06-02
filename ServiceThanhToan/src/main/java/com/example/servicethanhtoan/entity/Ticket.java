package com.example.servicethanhtoan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ve_xe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_dat")
    private String dateOrder;

    @Column(name = "trang_thai_thanh_toan")
    private int paymentStatus;

    @Column(name = "ma_ghe")
    private String seatName;

    @Column(name = "ho_ten_kh")
    private String fullName;

    @Column(name = "sdt_kh")
    private String phoneNumber;

    @Column(name = "email_kh")
    private String email;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "payment_method")
    private String paymentMethod;


    @ManyToOne
    @JoinColumn(name = "id_chuyen_xe")
    private ChuyenXe chuyenXe;


}
