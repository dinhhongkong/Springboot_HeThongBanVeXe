package com.example.servicelogin.controller;

import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.payload.RespondData;
import com.example.servicelogin.service.AuthAdminService;
import com.example.servicelogin.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthAdminController {
    private AuthAdminService service;
    @PostMapping("/admin/login")
    public ResponseEntity<?> adminLogin(@RequestBody AuthRequest authRequest){
        RespondData respondData= new RespondData();
        if(service.checkLogin(authRequest) == 0){
            respondData.setStatus(200);
            respondData.setData(service.generateToken(authRequest.getUsername()));
            respondData.setMessage("Login success");
        }else
        if (service.checkLogin(authRequest) == 2)
        {
            respondData.setStatus(404);
            respondData.setData("");
            respondData.setMessage("Not found account");
            return new ResponseEntity<>(respondData, HttpStatus.UNAUTHORIZED);
        }
        else
        {
            respondData.setStatus(401);
            respondData.setData("");
            respondData.setMessage("Wrong password");
            new ResponseEntity<>(respondData, HttpStatus.UNAUTHORIZED);

        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }
}
