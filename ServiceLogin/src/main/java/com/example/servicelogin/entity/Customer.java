package com.example.servicelogin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "khach_hang")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private int id;

    @Column(name = "ho_ten")
    private String fullName;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    private String email;

    @OneToOne
    @JoinColumn(name = "username")
    private Account account;
}
