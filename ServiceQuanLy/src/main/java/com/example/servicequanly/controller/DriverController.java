package com.example.servicequanly.controller;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.entity.Driver;
import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage")
@AllArgsConstructor
public class DriverController {
    private DriverService driverService;
    @GetMapping("/drivers")
    public ResponseEntity<?> getListDriver() {
        List<Driver> driverList = driverService.getListDriver();
        RespondData respondData = new RespondData();
        if (!driverList.isEmpty()) {
            respondData.setStatus(200);
            respondData.setData(driverList);
            respondData.setMessage("Lay Danh Sach Thanh Cong");
            return new ResponseEntity<>(respondData, HttpStatus.OK);

        }
        respondData.setStatus(HttpStatus.NO_CONTENT.value());
        respondData.setData(null);
        respondData.setMessage("Khong co du lieu");
        return new ResponseEntity<>(respondData, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/driver")
    public ResponseEntity<?> addNewDriver(@RequestBody DriverRequest driverRequest) {
        Driver driver = driverService.addNewDriver(driverRequest);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.CREATED.value());
        respondData.setData(driver);
        respondData.setMessage("Them tai xe Thanh Cong");
        return new ResponseEntity<>(respondData, HttpStatus.CREATED);
    }

    @PutMapping("/driver")
    public ResponseEntity<?> updateDriver(@RequestBody Driver BodyDriver) {
        Driver driver = driverService.updateDriver(BodyDriver);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.ACCEPTED.value());
        respondData.setData(driver);
        respondData.setMessage("Cap nhap tai xe thanh cong");
        return new ResponseEntity<>(driver, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/driver")
    public ResponseEntity<?> deleteDriver(@RequestParam int id) {
        Driver driver = driverService.deleteDriver(id);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.ACCEPTED.value());
        respondData.setData(driver);
        respondData.setMessage("Xoa tai xe thanh cong");
        return new ResponseEntity<>(driver, HttpStatus.ACCEPTED);
    }


}
