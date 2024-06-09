package com.example.servicequanly.mapper;

import com.example.servicequanly.dto.request.DriverRequest;
import com.example.servicequanly.dto.request.EmployeeCreationRequest;
import com.example.servicequanly.entity.Driver;
import com.example.servicequanly.entity.Employee;

public interface EmployeeMapper {
    Employee employeeCreationRequestToEmployee(EmployeeCreationRequest employeeCreationRequest);
}
