package com.assignment.startApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.startApp.entity.CustomerManagement;

@Repository
public interface CustomerManagementRepository extends JpaRepository<CustomerManagement, Integer> {
}
