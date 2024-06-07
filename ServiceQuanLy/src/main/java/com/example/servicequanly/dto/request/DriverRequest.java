package com.example.servicequanly.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverRequest {
    private String fullName;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;
    private String typeLicense;
}
