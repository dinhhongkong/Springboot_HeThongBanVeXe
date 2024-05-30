package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.VeXeDTO;
import com.example.sevicedatve.dto.VeXeRequestDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.KhachHang;
import com.example.sevicedatve.entity.QuanLy;
import com.example.sevicedatve.entity.VeXe;
import com.example.sevicedatve.repository.VeXeRepository;
import com.example.sevicedatve.service.Implement.VeXeImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeXeService implements VeXeImp {
    @Autowired
    VeXeRepository veXeRepository;
    @Override
    public List<Integer> insertVeXe(VeXeRequestDTO veXeRequestDTO) {
        List<Integer> listIdVeXe= new ArrayList<>();
        try{
            List<String> listSeat= new ArrayList<>();
            listSeat= veXeRequestDTO.getListSeat();
            for(int i= 0;  i<listSeat.size(); i++){
                VeXe veXe= new VeXe();
                veXe.setNgayDat(veXeRequestDTO.getNgayDat());
                veXe.setTrangThaiThanhToan(veXeRequestDTO.isTrangThaiThanhToan());
                veXe.setMaGhe(listSeat.get(i));

                if(veXeRequestDTO.getIdKhachHang() != -1){
                    KhachHang khachHang= new KhachHang();
                    khachHang.setId(veXeRequestDTO.getIdKhachHang());
                    veXe.setKhachHang(khachHang);
                }

                ChuyenXe chuyenXe= new ChuyenXe();
                chuyenXe.setId(veXeRequestDTO.getIdChuyenXe());
                veXe.setChuyenXe(chuyenXe);

                if(veXeRequestDTO.getIdQuanLy() != -1){
                    QuanLy quanLy= new QuanLy();
                    quanLy.setId(veXeRequestDTO.getIdQuanLy());
                    veXe.setQuanLy(quanLy);
                }

                veXe.setHoTenKH(veXeRequestDTO.getName());
                veXe.setPhoneKH(veXeRequestDTO.getPhone());
                veXe.setEmailKH(veXeRequestDTO.getEmail());

                veXeRepository.save(veXe);
                listIdVeXe.add(veXe.getId());
            }
            return listIdVeXe;

        }catch (Exception e){
            System.out.println("Insert Ve Xe That Bai" + e.getMessage());
        }
        return null;
    }

    public VeXeDTO insertTest(String name, String phone, String email){
        VeXeDTO veXeDTO= new VeXeDTO(name, phone, email);
        VeXe veXe= new VeXe();
        veXe.setHoTenKH(name);
        veXe.setPhoneKH(phone);
        veXe.setEmailKH(email);
        veXeRepository.save(veXe);
        return veXeDTO;
    }

    @Override
    public List<VeXeDTO> getAllVeXeByChuyenXe(int idChuyenXe) {
//        List<VeXeDTO> veXeDTOList= new ArrayList<>();
//        ChuyenXe chuyenXe= new ChuyenXe();
//        chuyenXe.setId(idChuyenXe);
//
//        List<VeXe> veXeList= veXeRepository.findAllByChuyenXe(chuyenXe);
//
//        for(VeXe veXe: veXeList){
//            VeXeDTO veXeDTO= new VeXeDTO();
//            veXeDTO.setId(veXe.getId());
//            veXeDTO.setNgayDat(veXe.getNgayDat());
//            veXeDTO.setMaGhe(veXe.getMaGhe());
//            veXeDTOList.add(veXeDTO);
//        }
        return null;
    }
}
