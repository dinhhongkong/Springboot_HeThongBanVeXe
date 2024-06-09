package com.example.servicequanly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "xe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bien_so")
    private String licensePlate;

    @Column(name = "tong_so_ghe")
    private int totalSeats;

    @Column(name = "loai_xe")
    private String bussType;

}
