package com.example.sevicedatve.repository;

import com.example.sevicedatve.entity.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends JpaRepository<Xe, Integer> {
    Xe findById(int id);
}
