package com.example.servicequanly.repository;

import com.example.servicequanly.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee deleteById(int id);
}
