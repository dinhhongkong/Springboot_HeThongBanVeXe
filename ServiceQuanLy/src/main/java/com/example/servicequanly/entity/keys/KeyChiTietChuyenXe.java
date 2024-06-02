package com.example.servicequanly.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyChiTietChuyenXe implements Serializable {
    @Column(name = "id_tai_xe")
    private int idTaiXe;

    @Column(name = "id_chuyen_xe")
    private int idChuyenXe;


}
