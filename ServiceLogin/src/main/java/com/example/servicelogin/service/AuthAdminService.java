package com.example.servicelogin.service;

import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.entity.Account;
import com.example.servicelogin.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthAdminService {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public int checkLogin(AuthRequest authRequest){
        Optional<Account> account = accountRepository.findByUsername(authRequest.getUsername());
        return account.map(value -> Boolean.compare(passwordEncoder.matches(authRequest.getPassword(), value.getPassword()), true)).orElse(2);
    }
    public String generateToken(String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        if (account.isPresent()) {
            claims.put("employeeId",account.get().getEmployee().getId());
            claims.put("roleName",account.get().getRole().getRoleName());
            claims.put("fullName",account.get().getEmployee().getFullName());
        }
        return jwtService.generateToken(claims,username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
