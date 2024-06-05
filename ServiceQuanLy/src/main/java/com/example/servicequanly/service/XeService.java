package com.example.servicequanly.service;

import com.example.servicequanly.dto.AddXeDTO;
import com.example.servicequanly.dto.XeDTO;

import java.util.List;

public interface XeService {
    List<XeDTO> getListXe();
    AddXeDTO insertXe(String bienSo, int tongSoGhe, String loaiXe);

    XeDTO update(int id, String bienSo, int tongSoGhe, String loaiXe);
}
