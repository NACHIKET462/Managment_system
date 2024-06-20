package com.assignment.startApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.startApp.entity.PayrollManagement;

@Repository
public interface PayrollManagementRepository extends JpaRepository<PayrollManagement, Integer> {
}
