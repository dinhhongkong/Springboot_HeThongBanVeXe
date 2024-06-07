package com.example.servicequanly.repository;

import com.example.servicequanly.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    void deleteById(int integer);
}
