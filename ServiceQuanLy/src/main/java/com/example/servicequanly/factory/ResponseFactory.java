package com.example.servicequanly.factory;

import com.example.servicequanly.entity.Employee;
import com.example.servicequanly.entity.Journey;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ResponseFactory {

    public <T> ResponseData<T> create(Class<T> modelClass, T data) {
        if (modelClass.isAssignableFrom(Employee.class)) {
            return new ResponseData<T>(200,"ok", data);
        }  else {
            throw new IllegalArgumentException("Unknown class: " + modelClass.getName());
        }
    }
}
