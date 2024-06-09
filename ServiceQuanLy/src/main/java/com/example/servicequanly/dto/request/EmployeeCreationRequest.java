package com.example.servicequanly.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreationRequest {
    private String fullName;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;
}
