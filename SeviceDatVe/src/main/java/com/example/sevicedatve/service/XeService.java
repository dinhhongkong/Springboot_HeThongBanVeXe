package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.XeDTO;
import com.example.sevicedatve.entity.Xe;
import com.example.sevicedatve.repository.XeRepository;
import com.example.sevicedatve.service.Implement.XeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XeService implements XeImp {

    @Autowired
    XeRepository xeRepository;
    @Override
    public List<XeDTO> getAllXe() {
        List<Xe> listXe= xeRepository.findAll();
        List<XeDTO> listXeDTO= new ArrayList<>();
        for (Xe data: listXe){
            XeDTO xeDTO= new XeDTO();
            xeDTO.setId(data.getId());
            xeDTO.setBienSo(data.getBienSo());
            xeDTO.setTongSoGhe(data.getTongSoGhe());
            xeDTO.setLoai_xe(data.getLoai_xe());
            listXeDTO.add(xeDTO);
        }
        return listXeDTO;
    }

    @Override
    public XeDTO getXeById(int id) {
        XeDTO xeDTO= new XeDTO();
        Xe data= xeRepository.findById(id);
        xeDTO.setId(data.getId());
        xeDTO.setBienSo(data.getBienSo());
        xeDTO.setTongSoGhe(data.getTongSoGhe());
        xeDTO.setLoai_xe(data.getLoai_xe());
        return xeDTO;
    }
}
