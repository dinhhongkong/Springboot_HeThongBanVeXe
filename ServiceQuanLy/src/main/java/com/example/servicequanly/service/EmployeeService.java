package com.example.servicequanly.service;

import com.example.servicequanly.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee save(Employee employee);
    Employee deleteById(int id);
}
