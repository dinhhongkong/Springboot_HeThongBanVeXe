package com.example.servicequanly.controller;

import com.example.servicequanly.dto.AddXeDTO;
import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/quanly")
public class XeController {
    @Autowired
    private XeService xeService;
    @GetMapping("/get-list-xe")
    public ResponseEntity<?> getListXe(){
        RespondData respondData= new RespondData();
        if(xeService.getListXe() != null){
            respondData.setStatus(200);
            respondData.setData(xeService.getListXe());
            respondData.setMessage("Lay Danh Sach Thanh Cong");
        }
        else {
            respondData.setStatus(204);
            respondData.setData(null);
            respondData.setMessage("Khong co du lieu");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertXe(@RequestParam String bienSo, @RequestParam int tongSoGhe, @RequestParam String loaiXe){
        RespondData respondData= new RespondData();
        AddXeDTO addXeDTO= xeService.insertXe(bienSo, tongSoGhe, loaiXe);
        if(addXeDTO != null){
            respondData.setStatus(200);
            respondData.setData(addXeDTO);
            respondData.setMessage("Them Xe Thanh Cong");
        }else{
            respondData.setStatus(204);
            respondData.setData(null);
            respondData.setMessage("Them Xe Khong Thanh Cong");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
