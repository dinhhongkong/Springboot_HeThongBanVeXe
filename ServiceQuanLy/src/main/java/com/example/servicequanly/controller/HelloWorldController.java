package com.example.servicequanly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/manage/helloworld")
    public String home() {
        return "helloworld quan ly";
    }

}
