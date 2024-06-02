package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.ListMaGheDaDatDTO;
import com.example.sevicedatve.dto.VeXeRequestDTO;
import com.example.sevicedatve.dto.VeXeTraCuuDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.KhachHang;
import com.example.sevicedatve.entity.QuanLy;
import com.example.sevicedatve.entity.VeXe;
import com.example.sevicedatve.repository.ChuyenXeRepository;
import com.example.sevicedatve.repository.VeXeRepository;
import com.example.sevicedatve.service.Implement.VeXeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeXeService implements VeXeImp {
    @Autowired
    VeXeRepository veXeRepository;

    @Autowired
    ChuyenXeRepository chuyenXeRepository;

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


    @Override
    public ListMaGheDaDatDTO getAllVeDaDatByIdChuyenXe(int idChuyenXe) {
        try{
            ListMaGheDaDatDTO listMaGheDaDat = new ListMaGheDaDatDTO();
            List<String> listMaGhe= new ArrayList<>();
            ChuyenXe chuyenXe= chuyenXeRepository.findById(idChuyenXe);

            if(chuyenXe != null) {
                List<VeXe> veXeList = veXeRepository.findAllByChuyenXe(chuyenXe);
                for (VeXe veXe : veXeList) {
                    listMaGhe.add(veXe.getMaGhe());
                }
                listMaGheDaDat.setListMaGheDaDat(listMaGhe);
                return listMaGheDaDat;
            }
        }catch (Exception e){
            System.out.println("Loi lay danh sach ma ghe da dat: " + e.getMessage());
        }
        return null;
    }

    @Override
    public VeXeTraCuuDTO getThongTinVeXeByPhoneKHAndMaGheAndNgayDat(String phone, String maGhe, String ngayDat) {
        try{
            VeXe veXe= veXeRepository.findByPhoneKHAndMaGheAndNgayDat(phone, maGhe, ngayDat);
            VeXeTraCuuDTO veXeTraCuuDTO= new VeXeTraCuuDTO();
            if(veXe != null){
                veXeTraCuuDTO.setName(veXe.getHoTenKH());
                veXeTraCuuDTO.setPhone(veXe.getPhoneKH());
                veXeTraCuuDTO.setEmail(veXe.getEmailKH());
                veXeTraCuuDTO.setNgayKhoiHanh(veXe.getChuyenXe().getNgayKhoiHanh());
                veXeTraCuuDTO.setGioXuatPhat(veXe.getChuyenXe().getGioXuatPhat());
                veXeTraCuuDTO.setTinhXuatPhat(veXe.getChuyenXe().getTinhDi().getTenTinh());
                veXeTraCuuDTO.setTinhDen(veXe.getChuyenXe().getTinhDen().getTenTinh());
                return veXeTraCuuDTO;
            }
        }catch (Exception e){
            System.out.println("lỗi tra cứu vé: " + e.getMessage());
        }

        return null;
    }
}
