package com.example.servicelogin.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ho_ten")
    private String fullName;

    @Column(name = "ngay_sinh")
    private String dateOfBirth;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    @Column(name = "que_quan")
    private String address;

    @OneToOne
    @JoinColumn(name = "username")
    private Account account;
}
