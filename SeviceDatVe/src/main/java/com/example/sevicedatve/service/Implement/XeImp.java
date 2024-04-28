package com.example.sevicedatve.service.Implement;

import com.example.sevicedatve.dto.XeDTO;
import com.example.sevicedatve.entity.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface XeImp{
    List<XeDTO> getAllXe();

    XeDTO getXeById(int id);
}
