package com.example.sevicedatve.repository;

import com.example.sevicedatve.entity.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeXeRepository extends JpaRepository<VeXe, Integer> {
}
