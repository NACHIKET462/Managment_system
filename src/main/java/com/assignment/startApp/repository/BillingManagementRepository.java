package com.assignment.startApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.startApp.entity.BillingManagement;

@Repository
public interface BillingManagementRepository extends JpaRepository<BillingManagement, Integer> {
}

