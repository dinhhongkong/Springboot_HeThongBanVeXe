package com.example.servicequanly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "quan_ly")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    private int id;
    @Column(name = "ho_ten")
    private String fullName;

    @Column(name = "ngay_sinh")
    private String dateOfBirth;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;
}
