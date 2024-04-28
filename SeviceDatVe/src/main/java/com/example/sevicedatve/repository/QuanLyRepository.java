package com.example.sevicedatve.repository;

import com.example.sevicedatve.entity.QuanLy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuanLyRepository extends JpaRepository<QuanLy, Integer> {
}
