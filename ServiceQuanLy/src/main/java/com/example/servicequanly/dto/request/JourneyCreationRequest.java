package com.example.servicequanly.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JourneyCreationRequest {
    private LocalDate departureDate;
    private String departureTime;
    private double estimatedTime;
    private double price;
    private int busId;
    private int employeeId;
    private int departureProvinceId;
    private int destProvinceId;
    private Set<Integer> drivers;
}
