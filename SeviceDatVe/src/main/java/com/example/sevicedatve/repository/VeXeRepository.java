package com.example.sevicedatve.repository;

import com.example.sevicedatve.dto.VeXeTraCuuDTO;
import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeXeRepository extends JpaRepository<VeXe, Integer> {
    List<VeXe> findAllByChuyenXe(ChuyenXe chuyenXe);

    VeXe findByPhoneKHAndMaGheAndNgayDat(String phone, String maGhe, String ngayDat);
}
