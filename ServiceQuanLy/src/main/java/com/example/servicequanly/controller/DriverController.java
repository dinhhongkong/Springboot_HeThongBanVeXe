package com.example.servicequanly.controller;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.entity.Driver;
import com.example.servicequanly.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/quanly")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping("/drivers")
    public ResponseEntity<?> getListDriver(){
        List<Driver> driverList= driverService.getListDriver();
        return new ResponseEntity<>(driverList, HttpStatus.OK);
    }

    @PostMapping("/driver")
    public  ResponseEntity<?> addNewDriver(@RequestBody DriverRequest driverRequest){
        Driver driver = driverService.addNewDriver(driverRequest);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }

    @PutMapping("/driver")
    public  ResponseEntity<?> updateDriver(@RequestBody Driver BodyDriver){
        Driver driver = driverService.updateDriver(BodyDriver);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }


    @DeleteMapping("/driver")
    public  ResponseEntity<?> deleteDriver(@RequestParam int id){
        Driver driver = driverService.deleteDriver(id);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }




}
