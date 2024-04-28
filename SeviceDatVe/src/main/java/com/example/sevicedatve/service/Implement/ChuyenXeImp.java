package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.ChuyenXeDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface ChuyenXeImp {
    List<ChuyenXeDTO> getAllChuyenXe();

    boolean insertChuyenXe(Date thoiGianKhoiHanh, double gia, int idQuanLy, int idXe, int maTinhDi, int maTinhDen);
}
