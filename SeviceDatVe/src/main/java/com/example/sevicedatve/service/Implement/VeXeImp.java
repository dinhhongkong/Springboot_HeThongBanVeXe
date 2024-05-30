package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.ListMaGheDaDatDTO;
import com.example.sevicedatve.dto.VeXeRequestDTO;

import java.util.List;

public interface VeXeImp {
    List<Integer> insertVeXe(VeXeRequestDTO veXeRequestDTO);

    ListMaGheDaDatDTO getAllVeDaDatByIdChuyenXe(int idChuyenXe);
}
