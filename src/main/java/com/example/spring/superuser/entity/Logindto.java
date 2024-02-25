package com.example.spring.superuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logindto {
    private String usernameorEmail;
    private String password;
}
