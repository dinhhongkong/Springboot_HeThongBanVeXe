package com.example.servicelogin.controller;


import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.dto.PasswordRequest;
import com.example.servicelogin.entity.Account;
import com.example.servicelogin.entity.Customer;
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
    public String test() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        RespondData respondData = new RespondData();
        if (service.checkLogin(authRequest) == 0) {
            respondData.setStatus(200);
            respondData.setData(service.generateToken(authRequest.getUsername()));
            respondData.setMessage("Login success");
        } else if (service.checkLogin(authRequest) == 2) {
            respondData.setStatus(404);
            respondData.setData("");
            respondData.setMessage("Not found account");
            return new ResponseEntity<>(respondData, HttpStatus.UNAUTHORIZED);
        } else {
            respondData.setStatus(401);
            respondData.setData("");
            respondData.setMessage("Wrong password");
            new ResponseEntity<>(respondData, HttpStatus.UNAUTHORIZED);

        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody Account account) {
        Account savedAccount = service.saveUser(account);
        RespondData respondData = new RespondData();
        if (savedAccount != null) {
            respondData.setStatus(200);
            respondData.setData(savedAccount);
            respondData.setMessage("Regis success");
        } else {
            respondData.setStatus(400);
            respondData.setData("");
            respondData.setMessage("Existed account");
        }
        return new ResponseEntity<>(respondData, HttpStatus.OK);
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

    @PutMapping("/customer")
    public ResponseEntity<?> updateInfo(@RequestBody Customer customer) {
        RespondData respondData = new RespondData();
        respondData.setStatus(200);
        respondData.setData(service.updateCustomer(customer));
        respondData.setMessage("Update success");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }

    @PutMapping("/customer/password")
    public ResponseEntity<?> updatePassword(@RequestBody PasswordRequest passwordRequest) {
        service.updatePassword(passwordRequest);
        RespondData respondData = new RespondData();
        respondData.setStatus(200);
        respondData.setData("oke");
        respondData.setMessage("Update success");
        return new ResponseEntity<>(respondData, HttpStatus.OK);
    }


    @GetMapping("/validate/{token}")
    public ResponseEntity<String> validateToken(@PathVariable("token") String token) {
        service.validateToken(token);
        return ResponseEntity.ok("Token is valid");
    }
}
