package com.example.servicequanly.service.imp;


import com.example.servicequanly.entity.Province;
import com.example.servicequanly.repository.ProvinceRepository;
import com.example.servicequanly.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImp implements ProvinceService {
    private final ProvinceRepository provinceRepository;
    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }
}
