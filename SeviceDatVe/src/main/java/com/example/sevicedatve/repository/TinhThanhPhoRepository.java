package com.example.sevicedatve.repository;

import com.example.sevicedatve.dto.TinhThanhPhoDTO;
import com.example.sevicedatve.entity.TinhThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhThanhPhoRepository extends JpaRepository<TinhThanhPho, Integer> {
    TinhThanhPho findTinhThanhPhoByMaTinh(int maTinh);
}
