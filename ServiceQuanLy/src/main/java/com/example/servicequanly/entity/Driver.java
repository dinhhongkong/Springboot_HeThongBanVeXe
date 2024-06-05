package com.example.servicequanly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tai_xe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {
    @Id
    private int id;
    @Column(name = "ho_ten")
    private String fullName;

    @Column(name = "ngay_sinh")
    private String dateOfBirth;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    @Column(name = "que_quan")
    private String queQuan;

    @Column(name = "loai_bang_lai")
    private String loaiBangLai;

}
