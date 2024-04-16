package com.example.servicethanhtoan.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thanhtoan")
public class TestController {
    @GetMapping("")
    public String testGateway() {
        return "thanh toan da thong";
    }
}
