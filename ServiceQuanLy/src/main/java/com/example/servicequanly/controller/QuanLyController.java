package com.example.servicequanly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuanLyController {
    @GetMapping("/quanly/home")
    public String home() {
        return "home quan ly";
    }

}
