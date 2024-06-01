package com.example.servicelogin.service;

import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.entity.Account;
import com.example.servicelogin.entity.Role;
import com.example.servicelogin.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;


    public int checkLogin(AuthRequest authRequest){
        Optional<Account> account = accountRepository.findByUsername(authRequest.getUsername());
        return account.map(value -> Boolean.compare(passwordEncoder.matches(authRequest.getPassword(), value.getPassword()), true)).orElse(2);
    }

    public Account saveUser(Account account){
        Optional<Account> accountCheck = accountRepository.findByUsername(account.getUsername());
        if (accountCheck.isPresent()) return null;
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(new Role().builder().id(1).build());
        return accountRepository.save(account);
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
