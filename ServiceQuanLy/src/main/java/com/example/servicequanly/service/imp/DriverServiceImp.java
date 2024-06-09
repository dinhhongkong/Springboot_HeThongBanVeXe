package com.example.servicequanly.service.imp;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.entity.Driver;
import com.example.servicequanly.mapper.DriverMapper;
import com.example.servicequanly.repository.DriverRepository;
import com.example.servicequanly.service.DriverService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverServiceImp implements DriverService {

    private DriverRepository driverRepository;

    private DriverMapper driverMapper;

    @Override
    public List<Driver> getListDriver() {
        return driverRepository.findAll();
    }

    @Override
    public Driver addNewDriver(DriverRequest driverRequest) {
        Driver driver = driverMapper.driverRequestToDriver(driverRequest);
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    @Transactional
    public Driver deleteDriver(int id) {
        Driver driver = driverRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id " + id));
        driverRepository.deleteById(id);
        return driver;
    }
}
