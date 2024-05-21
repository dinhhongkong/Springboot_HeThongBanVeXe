package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.TinhThanhPhoDTO;

import java.util.List;

public interface TinhThanhPhoImp {

    List<TinhThanhPhoDTO> getAllTinhThanhPho();

    TinhThanhPhoDTO getTinhThanhPhoById(int id);
}
