package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.ChuyenXeDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface ChuyenXeImp {
    List<ChuyenXeDTO> getAllChuyenXe();

    List<ChuyenXeDTO> getListChuyenXe(int maTinhDi, int maTinhDen, String ngayXuatPhat);

    boolean insertChuyenXe(String ngayKhoiHanh, double gia, int idQuanLy, int idXe, int maTinhDi, int maTinhDen);
}
