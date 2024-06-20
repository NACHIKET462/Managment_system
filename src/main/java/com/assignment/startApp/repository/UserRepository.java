package com.assignment.startApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.startApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);


}
