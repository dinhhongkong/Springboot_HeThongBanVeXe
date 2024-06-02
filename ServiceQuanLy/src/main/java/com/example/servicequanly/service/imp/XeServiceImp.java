package com.example.servicequanly.service.imp;

import com.example.servicequanly.dto.AddXeDTO;
import com.example.servicequanly.dto.XeDTO;
import com.example.servicequanly.entity.Xe;
import com.example.servicequanly.repository.XeRepository;
import com.example.servicequanly.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XeServiceImp implements XeService {
    @Autowired
    XeRepository xeRepository;
    @Override
    public List<XeDTO> getListXe() {
        try{
            List<Xe> listXe= xeRepository.findAll();
            List<XeDTO> xeDTOList = new ArrayList<>();
            if(listXe != null) {
                for (int i = 0; i < listXe.size(); i++) {
                    XeDTO xeDTO = new XeDTO();
                    xeDTO.setId(listXe.get(i).getId());
                    xeDTO.setBienSo(listXe.get(i).getBienSo());
                    xeDTO.setTongSoGhe(listXe.get(i).getTongSoGhe());
                    xeDTO.setLoaiXe(listXe.get(i).getLoai_xe());
                    xeDTOList.add(xeDTO);
                }
                return xeDTOList;
            }
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public AddXeDTO insertXe(String bienSo, int tongSoGhe, String loaiXe) {
        try{
            AddXeDTO addXeDTO= new AddXeDTO(bienSo, tongSoGhe, loaiXe);
            Xe xe= new Xe();
            xe.setBienSo(bienSo);
            xe.setTongSoGhe(tongSoGhe);
            xe.setLoai_xe(loaiXe);
            xeRepository.save(xe);
            return addXeDTO;
        }catch (Exception e){}
        return null;
    }
}
