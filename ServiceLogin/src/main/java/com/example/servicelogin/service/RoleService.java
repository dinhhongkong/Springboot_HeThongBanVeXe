package com.example.servicelogin.service;

import com.example.servicelogin.entity.Role;
import com.example.servicelogin.repository.RoleRepository;
import com.example.servicelogin.service.ServiceImp.RoleImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleImp {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findRoleById(int id) {
        return roleRepository.findRoleById(id);
    }
}
