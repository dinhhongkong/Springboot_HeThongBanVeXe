package com.example.servicequanly.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
