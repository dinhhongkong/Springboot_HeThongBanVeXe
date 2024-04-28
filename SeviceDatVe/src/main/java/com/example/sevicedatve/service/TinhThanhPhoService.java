package com.example.sevicedatve.service;

import com.example.sevicedatve.dto.TinhThanhPhoDTO;
import com.example.sevicedatve.entity.TinhThanhPho;
import com.example.sevicedatve.repository.TinhThanhPhoRepository;
import com.example.sevicedatve.service.Implement.TinhThanhPhoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TinhThanhPhoService implements TinhThanhPhoImp {
    @Autowired
    TinhThanhPhoRepository tinhThanhPhoRepository;

    @Override
    public List<TinhThanhPhoDTO> getAllTinhThanhPho() {
        List<TinhThanhPho> listData= tinhThanhPhoRepository.findAll();
        List<TinhThanhPhoDTO> listTinhThanhPhoDTO= new ArrayList<>();
        for(TinhThanhPho data: listData){
            TinhThanhPhoDTO tinhThanhPhoDTO= new TinhThanhPhoDTO();
            tinhThanhPhoDTO.setMaTinh(data.getMaTinh());
            tinhThanhPhoDTO.setTenTinh(data.getTenTinh());
            listTinhThanhPhoDTO.add(tinhThanhPhoDTO);
        }
        return listTinhThanhPhoDTO;
    }

    @Override
    public TinhThanhPhoDTO getTinhThanhPhoById(int maTinh) {
        TinhThanhPho tinhThanhPho= tinhThanhPhoRepository.findTinhThanhPhoByMaTinh(maTinh);
        TinhThanhPhoDTO tinhThanhPhoDTO= new TinhThanhPhoDTO();
        tinhThanhPhoDTO.setMaTinh(tinhThanhPho.getMaTinh());
        tinhThanhPhoDTO.setTenTinh(tinhThanhPho.getTenTinh());
        return tinhThanhPhoDTO;
    }
}
