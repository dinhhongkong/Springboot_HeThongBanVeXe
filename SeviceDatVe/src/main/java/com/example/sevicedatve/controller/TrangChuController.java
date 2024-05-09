package com.example.sevicedatve.controller;

import com.example.sevicedatve.dto.TinhThanhPhoDTO;
import com.example.sevicedatve.dto.XeDTO;
import com.example.sevicedatve.payload.RespondData;
import com.example.sevicedatve.service.Implement.TinhThanhPhoImp;
import com.example.sevicedatve.service.Implement.XeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/datve")
public class TrangChuController {
    @Autowired
    TinhThanhPhoImp tinhThanhPhoImp;

    @Autowired
    XeImp xeImp;

    @GetMapping("/test")
    public String test(){
        return "Day la trang chu dat ve";
    }

    @GetMapping("/get-all-province")
    public ResponseEntity<?> getAllTinhThanhPho(){
        RespondData respondData= new RespondData();
        List<TinhThanhPhoDTO> listTinhThanhPho= tinhThanhPhoImp.getAllTinhThanhPho();
        respondData.setData(listTinhThanhPho);
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @GetMapping("/get-tinh")
    public ResponseEntity<?> getTinhThanhPhoByMa(@RequestParam int maTinh){
        RespondData respondData= new RespondData();
        TinhThanhPhoDTO tinhThanhPhoDTO= tinhThanhPhoImp.getTinhThanhPhoById(maTinh);
        respondData.setData(tinhThanhPhoDTO);
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @GetMapping("/get-all-xe")
    public ResponseEntity<?> getAllXe(){
        RespondData respondData= new RespondData();
        respondData.setData(xeImp.getAllXe());
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @GetMapping("/get-xe")
    public ResponseEntity<?> getXeById(@RequestParam int id){
        RespondData respondData= new RespondData();
        XeDTO xeDTO= xeImp.getXeById(id);
        respondData.setData(xeDTO);
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

}
