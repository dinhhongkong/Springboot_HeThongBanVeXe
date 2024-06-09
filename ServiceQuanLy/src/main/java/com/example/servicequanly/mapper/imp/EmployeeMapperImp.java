package com.example.servicequanly.mapper.imp;

import com.example.servicequanly.dto.request.EmployeeCreationRequest;
import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImp implements EmployeeMapper {
    @Override
    public Employee employeeCreationRequestToEmployee(EmployeeCreationRequest employee) {
        return Employee.builder()
                .fullName(employee.getFullName())
                .dateOfBirth(employee.getDateOfBirth())
                .phoneNumber(employee.getPhoneNumber())
                .address(employee.getAddress())
                .build();
    }
}
