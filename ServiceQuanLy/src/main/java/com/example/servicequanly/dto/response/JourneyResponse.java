package com.example.servicequanly.dto.response;

import com.example.servicequanly.entity.Bus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JourneyResponse {
    private int id;
    private LocalDate departureDate;
    private String departureTime;
    private double estimatedTime;
    private double price;
    private Bus bus;
    private String departureProvince;
    private String destProvince;
}
