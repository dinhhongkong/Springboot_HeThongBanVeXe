package com.example.sevicedatve.controller;

import com.example.sevicedatve.dto.QuanLyDTO;
import com.example.sevicedatve.payload.RespondData;
import com.example.sevicedatve.service.Implement.QuanLyImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nvquanly")
public class QuanLyController {
    @Autowired
    QuanLyImp quanLyImp;


    @GetMapping("/get-all")
    public ResponseEntity<?> getAllQuanLy(){
        List<QuanLyDTO> quanLyDTOList= quanLyImp.getAllQuanLy();
        return new ResponseEntity<>(quanLyDTOList, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertNhanVien(@RequestBody QuanLyDTO quanLyDTO){
        RespondData respondData= new RespondData();
        try{
            respondData.setData(quanLyImp.insertQuanLy(quanLyDTO));
            respondData.setMessage("insert success");
            return new ResponseEntity<>(respondData, HttpStatus.OK);
        }catch (Exception e){
            respondData.setMessage("insert failsed");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
