package com.example.servicequanly.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusUpdateRequest {
    private int id;
    private String licensePlate;
    private String busType;
}
