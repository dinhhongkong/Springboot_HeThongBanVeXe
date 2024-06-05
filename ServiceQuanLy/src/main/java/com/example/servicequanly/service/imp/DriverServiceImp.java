package com.example.servicequanly.service.imp;

import com.example.servicequanly.dto.DriverDTO;
import com.example.servicequanly.entity.Driver;
import com.example.servicequanly.repository.DriverRepository;
import com.example.servicequanly.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImp implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<DriverDTO> getListDriver() {
        try{
            List<Driver> driverList= driverRepository.findAll();
            List<DriverDTO> driverDTOList= new ArrayList<>();
            for(Driver driver: driverList){
                DriverDTO driverDTO= new DriverDTO();
                driverDTO.setId(driver.getId());
                driverDTO.setFullName(driver.getFullName());
                driverDTO.setDateOfBirth(driver.getDateOfBirth());
                driverDTO.setPhoneNumber(driver.getPhoneNumber());
                driverDTO.setQueQuan(driver.getQueQuan());
                driverDTO.setLoaiBangLai(driver.getLoaiBangLai());
                driverDTOList.add(driverDTO);
            }
            return driverDTOList;
        }catch (Exception e){}
        return null;
    }
}
