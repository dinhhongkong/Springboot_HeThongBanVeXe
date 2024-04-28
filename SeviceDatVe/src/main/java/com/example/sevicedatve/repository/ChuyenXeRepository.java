package com.example.sevicedatve.repository;

import com.example.sevicedatve.entity.ChuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenXeRepository extends JpaRepository<ChuyenXe, Integer> {
}
