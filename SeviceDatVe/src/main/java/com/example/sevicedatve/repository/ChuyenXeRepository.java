package com.example.sevicedatve.repository;

import com.example.sevicedatve.entity.ChuyenXe;
import com.example.sevicedatve.entity.TinhThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChuyenXeRepository extends JpaRepository<ChuyenXe, Integer> {
    List<ChuyenXe> findAllByTinhDiAndTinhDenAndNgayKhoiHanh(TinhThanhPho tinhDi, TinhThanhPho tinhDen, String ngayXuatPhat);
}
