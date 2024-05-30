package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.ChuyenXeDTO;
import com.example.sevicedatve.entity.*;
import com.example.sevicedatve.repository.ChuyenXeRepository;
import com.example.sevicedatve.service.Implement.ChuyenXeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
            chuyenXeDTO.setNgayKhoiHanh(data.getNgayKhoiHanh());
            chuyenXeDTO.setGioXuatPhat(data.getGioXuatPhat());
            chuyenXeDTO.setThoiGianDuKien(data.getThoiGianDuKien());
            chuyenXeDTO.setGia(data.getGia());
            chuyenXeDTO.setIdQuanLy(data.getQuanLy().getId());
            chuyenXeDTO.setHoTenQuanLy(data.getQuanLy().getHoTen());
            chuyenXeDTO.setIdXe(data.getXe().getId());
            chuyenXeDTO.setMaTinhDi(data.getTinhDi().getMaTinh());
            chuyenXeDTO.setTenTinhDi(data.getTinhDi().getTenTinh());
            chuyenXeDTO.setMaTinhDen(data.getTinhDen().getMaTinh());
            chuyenXeDTO.setTenTinhDen(data.getTinhDen().getTenTinh());
            listChuyenXeDTO.add(chuyenXeDTO);
            System.out.println(data.getNgayKhoiHanh());
        }
        return listChuyenXeDTO;
    }

    @Override
    public List<ChuyenXeDTO> getListChuyenXe(int maTinhDi, int maTinhDen, String ngayXuatPhat) {
        List<ChuyenXeDTO> chuyenXeDTOList= new ArrayList<>();

        TinhThanhPho tinhThanhPhoDi= new TinhThanhPho();
        tinhThanhPhoDi.setMaTinh(maTinhDi);
        TinhThanhPho tinhThanhPhoDen= new TinhThanhPho();
        tinhThanhPhoDen.setMaTinh(maTinhDen);

        List<ChuyenXe> chuyenXeList= chuyenXeRepository.findAllByTinhDiAndTinhDenAndNgayKhoiHanh(tinhThanhPhoDi, tinhThanhPhoDen, ngayXuatPhat);

        for(ChuyenXe chuyenXe: chuyenXeList){
            ChuyenXeDTO chuyenXeDTO= new ChuyenXeDTO();
            chuyenXeDTO.setId(chuyenXe.getId());
            chuyenXeDTO.setGia(chuyenXe.getGia());
            chuyenXeDTO.setLoaiXe(chuyenXe.getXe().getLoai_xe());
            chuyenXeDTO.setNgayKhoiHanh(chuyenXe.getNgayKhoiHanh());
            chuyenXeDTO.setGioXuatPhat(chuyenXe.getGioXuatPhat());
            chuyenXeDTO.setThoiGianDuKien(chuyenXe.getThoiGianDuKien());
            chuyenXeDTO.setTenTinhDen(chuyenXe.getTinhDen().getTenTinh());
            chuyenXeDTO.setTenTinhDi(chuyenXe.getTinhDi().getTenTinh());
            Set<String> listMaGhe= new HashSet<>();
            for(VeXe veXe: chuyenXe.getListVeXe()){
                String maGhe= veXe.getMaGhe();
                listMaGhe.add(maGhe);
            }
            chuyenXeDTO.setListMaGhe(listMaGhe);

            int choTrong= chuyenXe.getXe().getTongSoGhe()- chuyenXe.getListVeXe().size();
            chuyenXeDTO.setChoTrong(choTrong);
            chuyenXeDTOList.add(chuyenXeDTO);
        }
        return chuyenXeDTOList;
    }


    @Override
    public boolean insertChuyenXe(String thoiGianKhoiHanh, double gia, int idQuanLy, int idXe, int maTinhDi, int maTinhDen) {
        boolean isSuccess= true;
        try {
            ChuyenXe chuyenXe= new ChuyenXe();
            chuyenXe.setNgayKhoiHanh(thoiGianKhoiHanh);
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
