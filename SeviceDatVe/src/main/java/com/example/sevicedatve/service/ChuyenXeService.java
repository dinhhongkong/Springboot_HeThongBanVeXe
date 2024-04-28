package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.ChuyenXeDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.QuanLy;
import com.example.sevicedatve.entity.TinhThanhPho;
import com.example.sevicedatve.entity.Xe;
import com.example.sevicedatve.repository.ChuyenXeRepository;
import com.example.sevicedatve.service.Implement.ChuyenXeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChuyenXeService implements ChuyenXeImp {
    @Autowired
    ChuyenXeRepository chuyenXeRepository;
    @Override
    public List<ChuyenXeDTO> getAllChuyenXe() {
        List<ChuyenXeDTO> listChuyenXeDTO= new ArrayList<>();
        for(ChuyenXe data: chuyenXeRepository.findAll()){
            ChuyenXeDTO chuyenXeDTO= new ChuyenXeDTO();
            chuyenXeDTO.setId(data.getId());
            chuyenXeDTO.setThoiGianKhoiHanh(data.getThoiGianKhoiHanh());
            chuyenXeDTO.setGia(data.getGia());
            chuyenXeDTO.setIdQuanLy(data.getQuanLy().getId());
            chuyenXeDTO.setHoTenQuanLy(data.getQuanLy().getHoTen());
            chuyenXeDTO.setIdXe(data.getXe().getId());
            chuyenXeDTO.setMaTinhDi(data.getTinhDi().getMaTinh());
            chuyenXeDTO.setTenTinhDi(data.getTinhDi().getTenTinh());
            chuyenXeDTO.setMaTinhDen(data.getTinhDen().getMaTinh());
            chuyenXeDTO.setTenTinhDen(data.getTinhDen().getTenTinh());
            listChuyenXeDTO.add(chuyenXeDTO);
        }
        return listChuyenXeDTO;
    }

    @Override
    public boolean insertChuyenXe(Date thoiGianKhoiHanh, double gia, int idQuanLy, int idXe, int maTinhDi, int maTinhDen) {
        boolean isSuccess= true;
        try {



            ChuyenXe chuyenXe= new ChuyenXe();
            chuyenXe.setThoiGianKhoiHanh(thoiGianKhoiHanh);
            chuyenXe.setGia(gia);

            QuanLy quanLy= new QuanLy();
            quanLy.setId(idQuanLy);
            chuyenXe.setQuanLy(quanLy);

            Xe xe= new Xe();
            xe.setId(idXe);
            chuyenXe.setXe(xe);

            TinhThanhPho tinhThanhPhoDi= new TinhThanhPho();
            tinhThanhPhoDi.setMaTinh(maTinhDi);
            chuyenXe.setTinhDi(tinhThanhPhoDi);

            TinhThanhPho tinhThanhPhoDen = new TinhThanhPho();
            tinhThanhPhoDen.setMaTinh(maTinhDen);
            chuyenXe.setTinhDen(tinhThanhPhoDen);

            chuyenXeRepository.save(chuyenXe);

        }catch (Exception e){
            System.out.println("Insert Chuyen Xe Failsed" + e.getMessage());
            isSuccess = false;
        }
        return false;
    }
}
