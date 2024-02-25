package com.example.spring.superuser.controller;


import com.example.spring.superuser.entity.Logindto;
import com.example.spring.superuser.entity.Registerdto;
import com.example.spring.superuser.service.Authservice;
import com.example.spring.superuser.service.Registerservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authcontroller {
    private Authservice authservice;
    private Registerservice registerservice;

//    public Authcontroller(Authservice authservice, Registerservice registerservice) {
//        this.authservice = authservice;
//        this.registerservice = registerservice;
//    }


//    @PostMapping("/login")
//    public ResponseEntity<String>login(@RequestBody Logindto logindto){
//        String logindto1 = authservice.Logindto(logindto);
//        return new ResponseEntity<>(logindto1, HttpStatus.OK);
//    }
//    @PostMapping("/register")
//    public ResponseEntity<String>register(@RequestBody Registerdto registerdto){
//        String response=registerservice.register(registerdto);
//        return new ResponseEntity<>(response,HttpStatus.CREATED);
//    }
}
