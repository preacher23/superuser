package com.example.spring.superuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registerdto {
    private String name;
    private String username;
    private String email;
    private String password;
}
