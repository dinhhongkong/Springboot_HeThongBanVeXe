package com.example.sevicedatve.controller;

import com.example.sevicedatve.dto.ListMaGheDaDatDTO;
import com.example.sevicedatve.dto.VeXeRequestDTO;
import com.example.sevicedatve.dto.VeXeTraCuuDTO;
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

    @GetMapping("/get-list-ve-da-dat")
    public ResponseEntity<?> getAllVeXeByChuyenXe(@RequestParam int idChuyenXe){
        RespondData respondData= new RespondData();
        ListMaGheDaDatDTO listMaGheDaDatDTO= veXeImp.getAllVeDaDatByIdChuyenXe(idChuyenXe);
        if(listMaGheDaDatDTO != null){
            if(listMaGheDaDatDTO.getListMaGheDaDat().isEmpty()){
                respondData.setStatus(201);
                respondData.setMessage("Danh sach ghe da dat rong");
            }else{
                respondData.setStatus(200);
                respondData.setMessage("Lay danh sach ghe da dat thanh cong");
            }
            respondData.setData(listMaGheDaDatDTO);
        }else{
            respondData.setStatus(405);
            respondData.setMessage("Lay danh sach ghe da dat that bai");
            respondData.setData(null);
        }
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

    @GetMapping("/tra-cuu-ve")
    public ResponseEntity<?> traCuuThongTinVe(@RequestParam String phone, @RequestParam String maGhe, @RequestParam String ngayDat){
        RespondData respondData= new RespondData();
        VeXeTraCuuDTO veXeTraCuuDTO= veXeImp.getThongTinVeXeByPhoneKHAndMaGheAndNgayDat(phone, maGhe, ngayDat);
        if(veXeTraCuuDTO != null){
            respondData.setStatus(200);
            respondData.setData(veXeTraCuuDTO);
            respondData.setMessage("lấy thong tin vé xe thành công");
        }else {
            respondData.setStatus(201);
            respondData.setData(null);
            respondData.setMessage("Không coá thông tin vé xe");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
