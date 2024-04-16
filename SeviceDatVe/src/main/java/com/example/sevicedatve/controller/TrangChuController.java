package com.example.sevicedatve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datve")
public class TrangChuController {
    @GetMapping("/test")
    public String test() {
        return "day la trang dat ve";
    }

}
