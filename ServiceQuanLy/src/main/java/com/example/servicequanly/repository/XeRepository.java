package com.example.servicequanly.repository;

import com.example.servicequanly.entity.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends JpaRepository<Xe, Integer> {
}
