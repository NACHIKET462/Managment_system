package com.assignment.startApp.service;

import com.assignment.startApp.entity.BillingManagement;
import com.assignment.startApp.repository.BillingManagementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingManagementService {

    @Autowired
    private BillingManagementRepository repository;

    public BillingManagement addBillingManagement(BillingManagement billingManagement) {
        return repository.save(billingManagement);
    }

    public List<BillingManagement> getAllBillingManagements() {
        return repository.findAll();
    }

    public void deleteBill(int id) {
        repository.deleteById(id);
    }
}

