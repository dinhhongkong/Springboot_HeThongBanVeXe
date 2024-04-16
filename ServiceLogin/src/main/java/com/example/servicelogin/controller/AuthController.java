package com.example.servicelogin.controller;


import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.entity.User;
import com.example.servicelogin.service.AuthService;
import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private AuthService service;
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        User savedUser = service.saveUser(user);
        if (savedUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
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
