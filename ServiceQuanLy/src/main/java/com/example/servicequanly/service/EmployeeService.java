package com.example.servicequanly.service;

import com.example.servicequanly.dto.request.EmployeeCreationRequest;
import com.example.servicequanly.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee createEmployee(EmployeeCreationRequest EmployeeCreationRequest);

    Employee updateEmployee(Employee employee);
    Employee deleteById(int id);
}
