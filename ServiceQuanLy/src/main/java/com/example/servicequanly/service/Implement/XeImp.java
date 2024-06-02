package com.example.servicequanly.service.Implement;

import com.example.servicequanly.dto.AddXeDTO;
import com.example.servicequanly.dto.XeDTO;

import java.util.List;

public interface XeImp {
    List<XeDTO> getListXe();
    AddXeDTO insertXe(String bienSo, int tongSoGhe, String loaiXe);
}
