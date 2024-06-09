package com.example.servicequanly.controller;


import com.example.servicequanly.dto.request.EmployeeCreationRequest;
import com.example.servicequanly.entity.Employee;

import com.example.servicequanly.payload.RespondData;
import com.example.servicequanly.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        RespondData respondData = new RespondData();
        if (!employeeList.isEmpty()) {
            respondData.setStatus(200);
            respondData.setData(employeeList);
            respondData.setMessage("Lay danh sach thanh cong");
            return new ResponseEntity<>(respondData, HttpStatus.OK);

        }
        respondData.setStatus(HttpStatus.NO_CONTENT.value());
        respondData.setData(null);
        respondData.setMessage("Khong co du lieu");
        return new ResponseEntity<>(respondData, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeCreationRequest employee) {
        Employee employeeSaved = employeeService.createEmployee(employee);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.CREATED.value());
        respondData.setData(employeeSaved);
        respondData.setMessage("Thêm thành công");
        return new ResponseEntity<>(respondData, HttpStatus.CREATED);
    }

    @PutMapping("/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        Employee employeeSaved = employeeService.updateEmployee(employee);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.ACCEPTED.value());
        respondData.setData(employeeSaved);
        respondData.setMessage("Update thành công");
        return new ResponseEntity<>(respondData, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") int id) {
        Employee employeeDeleted = employeeService.deleteById(id);
        RespondData respondData = new RespondData();
        respondData.setStatus(HttpStatus.ACCEPTED.value());
        respondData.setData(employeeDeleted);
        respondData.setMessage("Xóa thành công");
        return new ResponseEntity<>(respondData, HttpStatus.ACCEPTED);
    }
}
