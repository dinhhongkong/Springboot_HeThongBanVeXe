package com.example.sevicedatve.controller;

import com.example.sevicedatve.entity.VeXe;
import com.example.sevicedatve.payload.RespondData;
import com.example.sevicedatve.service.Implement.VeXeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/vexe")
public class VeXeController {
    @Autowired
    VeXeImp veXeImp;
    @GetMapping("/test")
    public String test(){
        return "Day la trang ve xe";
    }

    @PostMapping("insert")
    public ResponseEntity<?> insertVeXe(@RequestParam Date ngayDat, @RequestParam boolean trangThaiThanhToan, @RequestParam String maGhe, @RequestParam int idKhachHang, @RequestParam int idChuyenXe, @RequestParam int idQuanLy){
        RespondData respondData= new RespondData();
        boolean isSuccess = veXeImp.insertVeXe(ngayDat, trangThaiThanhToan, maGhe, idKhachHang, idChuyenXe, idQuanLy);
        respondData.setData(isSuccess);
        respondData.setMessage("insert success");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
