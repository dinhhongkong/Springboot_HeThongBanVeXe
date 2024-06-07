package com.example.servicequanly.service;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.entity.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getListDriver();

    Driver addNewDriver(DriverRequest driverRequest);

    Driver updateDriver(Driver driver);

    Driver deleteDriver(int id);
}
