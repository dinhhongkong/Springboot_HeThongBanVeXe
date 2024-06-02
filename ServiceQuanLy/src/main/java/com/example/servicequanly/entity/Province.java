package com.example.servicequanly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tinh_thanh_pho")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Province {
    @Id
    private int provinceId;

    @Column(name = "ten_tinh")
    private String provinceName;


}
