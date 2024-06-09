package com.example.servicequanly.service.imp;

import com.example.servicequanly.dto.request.EmployeeCreationRequest;
import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.mapper.EmployeeMapper;
import com.example.servicequanly.repository.EmployeeRepository;
import com.example.servicequanly.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(EmployeeCreationRequest employeeCreationRequest) {
        Employee employee = employeeMapper.employeeCreationRequestToEmployee(employeeCreationRequest);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));
        employeeRepository.deleteById(id);
        return employee;
    }
}
