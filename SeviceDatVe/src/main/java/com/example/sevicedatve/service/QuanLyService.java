package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.QuanLyDTO;
import com.example.sevicedatve.entity.QuanLy;
import com.example.sevicedatve.repository.QuanLyRepository;
import com.example.sevicedatve.service.Implement.QuanLyImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuanLyService implements QuanLyImp {

    @Autowired
    QuanLyRepository quanLyRepository;

    @Override
    public List<QuanLyDTO> getAllQuanLy() {
        List<QuanLyDTO> quanLyDTOList= new ArrayList<>();

        List<QuanLy> listData= quanLyRepository.findAll();

        for(QuanLy data: listData){
            QuanLyDTO quanLyDTO= new QuanLyDTO();
            quanLyDTO.setId(data.getId());
            quanLyDTO.setHoTen(data.getHoTen());
            quanLyDTO.setNgaySinh(data.getNgaySinh());
            quanLyDTO.setSoDienThoai(data.getSoDienThoai());
            quanLyDTO.setQueQuan(data.getQueQuan());
            quanLyDTOList.add(quanLyDTO);
        }

        return quanLyDTOList;
    }

    @Override
    public boolean insertQuanLy(QuanLyDTO quanLyDTO) {
        QuanLy quanLy= new QuanLy();
        quanLy.setId(quanLyDTO.getId());
        quanLy.setHoTen(quanLyDTO.getHoTen());
        quanLy.setNgaySinh(quanLyDTO.getNgaySinh());
        quanLy.setSoDienThoai(quanLyDTO.getSoDienThoai());
        quanLy.setQueQuan(quanLyDTO.getQueQuan());
        quanLyRepository.save(quanLy);
        return true;
    }
}
