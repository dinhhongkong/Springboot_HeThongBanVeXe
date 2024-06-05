package com.example.servicequanly.controller;

import com.example.servicequanly.dto.DriverDTO;
import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.imp.DriverServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/quanly")
public class DriverController {
    @Autowired
    DriverServiceImp driverServiceImp;
    @GetMapping("/get-list-driver")
    public ResponseEntity<?> getListDriver(){
        RespondData respondData= new RespondData();
        List<DriverDTO> driverDTOList= driverServiceImp.getListDriver();
        if(driverDTOList != null){
            respondData.setStatus(200);
            respondData.setData(driverDTOList);
            respondData.setMessage("Lấy Danh Sách Tài Xế Thành Công");
        }else {
            respondData.setStatus(204);
            respondData.setData(null);
            respondData.setMessage("Danh Sách Rỗng");
        }

        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
