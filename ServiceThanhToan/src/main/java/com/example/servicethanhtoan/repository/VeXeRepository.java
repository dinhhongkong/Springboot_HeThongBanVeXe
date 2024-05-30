package com.example.servicethanhtoan.repository;

import com.example.servicethanhtoan.entity.ChuyenXe;
import com.example.servicethanhtoan.entity.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VeXeRepository extends JpaRepository<VeXe,Integer> {
    VeXe save(VeXe veXe);
    VeXe findById(int id);


}
