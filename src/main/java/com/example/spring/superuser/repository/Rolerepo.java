package com.example.spring.superuser.repository;

import com.example.spring.superuser.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Rolerepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
