package com.example.servicelogin.repository;

import com.example.servicelogin.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    Account findByUsername(String username);
}
