package com.example.servicequanly.exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class EntityNotFoundHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .details(request.getDescription(false))
                .message( exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }



}
