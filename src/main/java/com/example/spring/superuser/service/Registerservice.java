package com.example.spring.superuser.service;

import com.example.spring.superuser.entity.Myuser;
import com.example.spring.superuser.entity.Registerdto;
import com.example.spring.superuser.entity.Role;
import com.example.spring.superuser.repository.Rolerepo;
import com.example.spring.superuser.repository.Userrepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class Registerservice {
    private AuthenticationManager authenticationManager;
    private Userrepo userrepository;
    private Rolerepo rolerepo;

    private PasswordEncoder passwordEncoder;

    public Registerservice(AuthenticationManager authenticationManager, Userrepo userrepository, Rolerepo rolerep ,PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userrepository = userrepository;
        this.rolerepo = rolerepo;
        this.passwordEncoder=passwordEncoder;
    }

//    public String register(Registerdto registerdto){
//      //add check for username exists in dtatbase
//        if (userrepository.existsbyusername(registerdto.getUsername())){
//            throw new RuntimeException("exists");
//        }
//        //add check for email
//        if (userrepository.existsbyemail(registerdto.getEmail())){
//             throw new RuntimeException("exists");
//        }
//        Myuser myuser=new Myuser();
//        myuser.setEmail(registerdto.getEmail());
//        myuser.setName(registerdto.getName());
//        myuser.setUsername(registerdto.getUsername());
//        myuser.setPassword(passwordEncoder.encode(registerdto.getPassword()));
//
//        Set<Role>roles =new HashSet<>();
//        Role user=rolerepo.findByName("role_user").get();
//        roles.add(user);
//        myuser.setRoles(roles);
//        userrepository.save(myuser);
//        return "user successfully";
//    }
}
