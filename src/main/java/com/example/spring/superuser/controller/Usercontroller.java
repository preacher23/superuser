package com.example.spring.superuser.controller;

import com.example.spring.superuser.dto.Userdto;
import com.example.spring.superuser.entity.User;
import com.example.spring.superuser.exception.Errordetails;
import com.example.spring.superuser.exception.Resourcenotfoundexception;
import com.example.spring.superuser.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class Usercontroller {
    @Autowired
    private Userservice userservice;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity <Userdto> createuser(@Valid @RequestBody Userdto user){
        Userdto createuse = userservice.createuse(user);
        return new ResponseEntity<>(createuse, HttpStatus.CREATED);
    }
   @GetMapping("/get/{id1}")
    public ResponseEntity<Userdto> getuserbyid(@PathVariable Long id1){
        Userdto getuser = userservice.getuserbyid(id1);
        return new ResponseEntity<>(getuser,HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Userdto>> findalluser(){
        List<Userdto> findalluser = userservice.findalluser();
        return new ResponseEntity<>(findalluser,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Userdto> updateuser( @PathVariable Long id,@RequestBody @Valid Userdto user){
        user.setId(id);
        Userdto updateuser = userservice.updateuser(user);
        return new ResponseEntity<>(updateuser,HttpStatus.CREATED);
    }
   @ExceptionHandler(Resourcenotfoundexception.class)
    public ResponseEntity<Errordetails> handleresourcenotfoundexception(Resourcenotfoundexception resourcenotfoundexception,
                                                                        WebRequest request){
        Errordetails errordetails=new Errordetails(LocalDateTime.now(),
        resourcenotfoundexception.getMessage(),
        request.getDescription(false),
        "USER_NOT_FOUND");
        return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
    }
}
