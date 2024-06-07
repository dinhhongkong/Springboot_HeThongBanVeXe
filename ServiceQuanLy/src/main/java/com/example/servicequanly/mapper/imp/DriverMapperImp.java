package com.example.servicequanly.mapper.imp;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.entity.Driver;
import com.example.servicequanly.mapper.DriverMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverMapperImp implements DriverMapper {
    @Override
    public Driver driverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .fullName(driverRequest.getFullName())
                .dateOfBirth(driverRequest.getDateOfBirth())
                .address(driverRequest.getAddress())
                .phoneNumber(driverRequest.getPhoneNumber())
                .typeLicense(driverRequest.getTypeLicense())
                .build();
    }
}
