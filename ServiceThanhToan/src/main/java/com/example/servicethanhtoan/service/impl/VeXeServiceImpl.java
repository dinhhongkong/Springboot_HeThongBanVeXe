package com.example.servicethanhtoan.service.impl;

import com.example.servicethanhtoan.entity.VeXe;
import com.example.servicethanhtoan.repository.VeXeRepository;
import com.example.servicethanhtoan.service.VeXeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeXeServiceImpl implements VeXeService {

    private final VeXeRepository veXeRepository;

    @Override
    public VeXe findById(int id) {
        return veXeRepository.findById(id);
    }

    @Override
    public VeXe save(VeXe veXe) {
        return veXeRepository.save(veXe);
    }
}
