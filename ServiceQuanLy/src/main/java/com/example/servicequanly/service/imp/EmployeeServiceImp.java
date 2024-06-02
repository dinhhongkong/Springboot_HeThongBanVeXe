package com.example.servicequanly.service.imp;

import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.exception.EmployeeNotFoundException;
import com.example.servicequanly.repository.EmployeeRepository;
import com.example.servicequanly.service.EmployeeService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteById(int id) {
        Employee employee = employeeRepository.deleteById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Không tìm tất nhân viên để xóa");
        }
        return employee;
    }
}
