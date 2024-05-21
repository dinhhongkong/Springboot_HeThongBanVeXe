package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.VeXeDTO;

import java.util.Date;
import java.util.List;

public interface VeXeImp {
    boolean insertVeXe(Date  ngayDat, boolean trangThaiThanhToan, String maGhe, int idKhachHang, int idChuyenXe, int idQuanLy);

    List<VeXeDTO> getAllVeXeByChuyenXe(int idChuyenXe);
}
