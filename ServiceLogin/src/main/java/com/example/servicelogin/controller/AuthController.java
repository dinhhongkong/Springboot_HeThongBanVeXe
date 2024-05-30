package com.example.servicelogin.controller;


import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.entity.Account;
import com.example.servicelogin.payload.RespondData;
import com.example.servicelogin.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private AuthService service;
    private AuthenticationManager authenticationManager;

    @GetMapping("/test")
    public String test(){
        return "login";
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
        RespondData respondData= new RespondData();
        if(service.checkLogin(authRequest)){
            respondData.setStatus(200);
            respondData.setData(service.generateToken(authRequest.getUsername()));
            respondData.setMessage("login success");
        }else {
            respondData.setStatus(400);
            respondData.setData("");
            respondData.setMessage("login failed");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody Account account) {
        Account savedAccount = service.saveUser(account);
        if (savedAccount != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }


    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return ResponseEntity.ok("Token is valid");
    }
}
