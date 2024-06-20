package com.assignment.startApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.startApp.entity.UserManagement;

@Repository
public interface UserManagementRepository extends JpaRepository<UserManagement, Integer> {
}

