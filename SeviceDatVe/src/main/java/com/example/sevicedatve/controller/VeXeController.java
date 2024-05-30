package com.example.sevicedatve.controller;

import com.example.sevicedatve.dto.VeXeRequestDTO;
import com.example.sevicedatve.entity.VeXe;
import com.example.sevicedatve.payload.RespondData;
import com.example.sevicedatve.service.Implement.VeXeImp;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/vexe")
public class VeXeController {
    @Autowired
    VeXeImp veXeImp;
    @GetMapping("/test")
    public String test(){
        return "Day la trang ve xe";
    }

    @GetMapping("/get-all-ve-xe-by-chuyen-xe")
    public ResponseEntity<?> getAllVeXeByChuyenXe(@RequestParam int idChuyenXe){
        RespondData respondData= new RespondData();
        respondData.setStatus(202);
        respondData.setMessage("get success");
        respondData.setData(veXeImp.getAllVeXeByChuyenXe(idChuyenXe));
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertVeXe(@RequestBody VeXeRequestDTO veXeRequestDTO){
        System.out.println("run");
        RespondData respondData= new RespondData();
        List<Integer> listIdVeXe = veXeImp.insertVeXe(veXeRequestDTO);
        respondData.setStatus(200);
        respondData.setData(listIdVeXe);
        respondData.setMessage("insert success");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PostMapping("/test/insert")
    public ResponseEntity<?> insertTest(@RequestParam String name, @RequestParam String phone, @RequestParam String email){
        RespondData respondData= new RespondData();
        respondData.setData(veXeImp.insertTest(name, phone, email));
        return new ResponseEntity<>(respondData ,HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestParam int id){
        RespondData respondData= new RespondData();
        respondData.setData(1);
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
