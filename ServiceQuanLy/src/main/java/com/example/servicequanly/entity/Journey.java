package com.example.servicequanly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "chuyen_xe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Journey {
    @Id
    private int id;

    @Column(name = "ngay_khoi_hanh")
    private String departureDate;

    @Column(name = "gio_xuat_phat")
    private String departureTime;

    @Column(name = "thoi_gian_du_kien")
    private double estimatedTime;

    @Column(name = "gia")
    private double price;

    @ManyToOne
    @JoinColumn(name = "ma_tinh_di")
    private Province startProvince;

    @ManyToOne
    @JoinColumn(name = "ma_tinh_den")
    private Province destProvince;

    @ManyToOne
    @JoinColumn(name = "id_quan_ly")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_xe")
    private Xe xe;






}
