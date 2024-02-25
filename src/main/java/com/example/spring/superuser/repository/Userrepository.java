package com.example.spring.superuser.repository;

import com.example.spring.superuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User,Long> {
}
