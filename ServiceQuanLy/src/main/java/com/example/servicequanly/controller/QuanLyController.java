package com.example.servicequanly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quanly")
public class QuanLyController {
    @GetMapping("/home")
    public String home() {
        return "home quan ly";
    }

}
