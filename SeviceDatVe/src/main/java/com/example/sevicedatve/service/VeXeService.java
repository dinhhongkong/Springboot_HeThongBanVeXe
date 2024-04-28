package com.example.sevicedatve.service;

import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.KhachHang;
import com.example.sevicedatve.entity.QuanLy;
import com.example.sevicedatve.entity.VeXe;
import com.example.sevicedatve.repository.VeXeRepository;
import com.example.sevicedatve.service.Implement.VeXeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VeXeService implements VeXeImp {
    @Autowired
    VeXeRepository veXeRepository;
    @Override
    public boolean insertVeXe(Date ngayDat, boolean trangThaiThanhToan, String maGhe, int idKhachHang, int idChuyenXe, int idQuanLy) {
        boolean isSucess= true;
        try{
            VeXe veXe= new VeXe();
            veXe.setNgayDat(ngayDat);
            veXe.setTrangThaiThanhToan(trangThaiThanhToan);
            veXe.setMaGhe(maGhe);

            KhachHang khachHang= new KhachHang();
            khachHang.setId(idKhachHang);
            veXe.setKhachHang(khachHang);

            ChuyenXe chuyenXe= new ChuyenXe();
            chuyenXe.setId(idChuyenXe);
            veXe.setChuyenXe(chuyenXe);

            QuanLy quanLy= new QuanLy();
            quanLy.setId(idQuanLy);
            veXe.setQuanLy(quanLy);
            veXeRepository.save(veXe);
        }catch (Exception e){
            System.out.println("Insert Ve Xe That Bai" + e.getMessage());
            isSucess= false;
        }
        return isSucess;
    }
}
