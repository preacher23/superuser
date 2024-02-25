package com.example.spring.superuser.service;

import com.example.spring.superuser.entity.Logindto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Authservice {
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    public Authservice(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    public String Logindto(Logindto logindto){
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                logindto.getUsernameorEmail(), logindto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authenticate);
//        return "user logged in successfully";
//    }
}
