package com.example.servicequanly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(JourneyDetail.class)
@Entity(name = "chi_tiet_chuyen_xe")
public class JourneyDetail implements Serializable {
    @Id
    @Column(name = "id_tai_xe")
    private int driverId;
    @Id
    @Column(name = "id_chuyen_xe")
    private int journeyId;
}
