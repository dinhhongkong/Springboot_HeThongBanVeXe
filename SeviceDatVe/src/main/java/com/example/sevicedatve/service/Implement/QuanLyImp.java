package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.QuanLyDTO;
import com.example.sevicedatve.entity.QuanLy;

import java.util.List;

public interface QuanLyImp {
    List<QuanLyDTO> getAllQuanLy();

    boolean insertQuanLy(QuanLyDTO quanLyDTO);
}
