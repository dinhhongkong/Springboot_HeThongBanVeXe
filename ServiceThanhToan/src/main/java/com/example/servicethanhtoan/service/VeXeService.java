package com.example.servicethanhtoan.service;

import com.example.servicethanhtoan.entity.VeXe;

public interface VeXeService {
    VeXe findById(int id);
    VeXe save(VeXe veXe);
}
