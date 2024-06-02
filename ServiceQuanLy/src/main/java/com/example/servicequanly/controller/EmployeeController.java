package com.example.servicequanly.controller;


import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.factory.ResponseData;
import com.example.servicequanly.factory.ResponseFactory;
import com.example.servicequanly.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quanly")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeList);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        Employee employeeSaved = employeeService.save(employee);
        return ResponseEntity.ok(employeeSaved);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> delele(@RequestParam int id) {
        Employee employeeDeleted = employeeService.deleteById(id);
        return ResponseEntity.ok(employeeDeleted);
    }
}
