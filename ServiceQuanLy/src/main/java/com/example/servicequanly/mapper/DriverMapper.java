package com.example.servicequanly.mapper;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.entity.Driver;

public interface DriverMapper {
    Driver driverRequestToDriver(DriverRequest driverRequest);
}
