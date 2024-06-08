package com.example.servicelogin.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {
    private String username;
    private int roleId;
    @Override
    public String toString() {
        return "{\"username\":\"" + username + "\", \"roleId\":" + roleId + "}";
    }
}
