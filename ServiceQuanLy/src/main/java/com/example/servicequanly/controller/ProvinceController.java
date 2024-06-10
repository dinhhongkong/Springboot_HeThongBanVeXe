package com.example.servicequanly.controller;

import com.example.servicequanly.entity.Province;
import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;

    @GetMapping("/provinces")
    public  ResponseEntity<?> getAllProvince() {
        List<Province> provinces = provinceService.getAllProvince();
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.OK.value());
        respondData.setData(provinces);
        respondData.setMessage("Lấy danh sách tỉnh thành thành công");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }


}
