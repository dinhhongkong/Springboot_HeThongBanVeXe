package com.example.servicelogin.service;

import com.example.servicelogin.dto.AccountResponse;
import com.example.servicelogin.dto.AuthRequest;
import com.example.servicelogin.dto.PasswordRequest;
import com.example.servicelogin.entity.Account;
import com.example.servicelogin.entity.Customer;
import com.example.servicelogin.entity.Role;
import com.example.servicelogin.repository.AccountRepository;
import com.example.servicelogin.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;


    public int checkLogin(AuthRequest authRequest){
        Optional<Account> account = accountRepository.findByUsername(authRequest.getUsername());
        return account.map(value -> Boolean.compare(passwordEncoder.matches(authRequest.getPassword(), value.getPassword()), true)).orElse(2);
    }

    @Transactional
    public Account saveUser(Account account){
        Optional<Account> accountCheck = accountRepository.findByUsername(account.getUsername());
        if (accountCheck.isPresent()) return null;
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Role.builder().id(1).build());
        account= accountRepository.save(account);
        customerRepository.save(Customer.builder().account(Account.builder().username(account.getUsername()).build()).build());

        return account;
    }

    public String generateToken(String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        if (account.isPresent() && account.get().getCustomer() != null ) {

            claims.put("customerId",account.get().getCustomer().getId());
            claims.put("fullName",account.get().getCustomer().getFullName());
            claims.put("phoneNumber",account.get().getCustomer().getPhoneNumber());
            claims.put("email",account.get().getCustomer().getEmail());
        }
        return jwtService.generateToken(claims,username);
    }

    public Customer updateCustomer(Customer customer) {
        Customer customerDB = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerDB.setFullName(customer.getFullName());
        customerDB.setPhoneNumber(customer.getPhoneNumber());
        customerDB.setEmail(customer.getEmail());
        customerRepository.save(customerDB);
        return customer;
    }

    public void updatePassword(PasswordRequest passwordRequest) {
        Customer customerDB = customerRepository.findById(passwordRequest.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));


        if(passwordEncoder.matches( passwordRequest.getOldPassword(), customerDB.getAccount().getPassword())) {
            String newPassword = passwordEncoder.encode(passwordRequest.getNewPassword());
            Account account = customerDB.getAccount();
            account.setPassword(newPassword);
            accountRepository.save(account);
        }
        else {
            throw new RuntimeException("Mật khẩu cũ không chính xác");
        }
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
