package com.example.servicequanly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorlController {
    @GetMapping("/quanly/helloworld")
    public String home() {
        return "helloworld quan ly";
    }

}
