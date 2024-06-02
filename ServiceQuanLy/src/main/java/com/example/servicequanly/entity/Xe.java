package com.example.servicequanly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name= "xe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Set<Journey> listChuyenXe;




}
