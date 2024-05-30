package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.VeXeDTO;
import com.example.sevicedatve.dto.VeXeRequestDTO;

import java.util.Date;
import java.util.List;

public interface VeXeImp {
    List<Integer> insertVeXe(VeXeRequestDTO veXeRequestDTO);

    VeXeDTO insertTest(String name, String phone, String email);

    List<VeXeDTO> getAllVeXeByChuyenXe(int idChuyenXe);
}
