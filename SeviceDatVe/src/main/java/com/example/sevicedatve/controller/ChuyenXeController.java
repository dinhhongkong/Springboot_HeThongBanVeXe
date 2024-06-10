package com.example.sevicedatve.controller;

import com.example.sevicedatve.dto.ChuyenXeDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.payload.RespondData;
import com.example.sevicedatve.service.Implement.ChuyenXeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/chuyenxe")
public class ChuyenXeController {
    @Autowired
    ChuyenXeImp chuyenXeImp;


    @GetMapping("/get-all")
    public ResponseEntity<?> getAllChuyenXe(){
        RespondData respondData= new RespondData();
        List<ChuyenXeDTO> chuyenXeList= chuyenXeImp.getAllChuyenXe();
        respondData.setData(chuyenXeList);
        return new ResponseEntity<>(respondData,  HttpStatus.OK);
    }

    @GetMapping("/get-chuyen-xe")
    public ResponseEntity<?> getChuyenXe(@RequestParam int maTinhDi, @RequestParam int maTinhDen, @RequestParam String ngayXuatPhat){
        RespondData respondData= new RespondData();
        respondData.setStatus(200);
        respondData.setData(chuyenXeImp.getListChuyenXe(maTinhDi, maTinhDen, ngayXuatPhat));
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertChuyenXe(@RequestParam String thoiGianKhoiHanh, @RequestParam double gia, @RequestParam int idQuanLy, @RequestParam int idXe, @RequestParam int maTinhDi, @RequestParam int maTinhDen){
        RespondData respondData= new RespondData();
        boolean isSuccess= chuyenXeImp.insertChuyenXe(thoiGianKhoiHanh, gia, idQuanLy, idXe, maTinhDi, maTinhDen);
        respondData.setMessage("insert menu success");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
