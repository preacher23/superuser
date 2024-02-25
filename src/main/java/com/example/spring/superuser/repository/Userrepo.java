package com.example.spring.superuser.repository;

import com.example.spring.superuser.entity.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepo extends JpaRepository<Myuser ,Long> {

    Optional<Myuser> findByEmail(String email);
    Optional<Myuser>findByUsernameOrEmail(String username,String email);
    Optional<Myuser>findByUsername(String username);
}
