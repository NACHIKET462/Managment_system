package com.assignment.startApp.service;


import com.assignment.startApp.entity.PayrollManagement;
import com.assignment.startApp.repository.PayrollManagementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollManagementService {

    @Autowired
    private PayrollManagementRepository repository;

    public PayrollManagement addPayroll(PayrollManagement payroll) {
        return repository.save(payroll);
    }

    public List<PayrollManagement> getAllPayrolls() {
        return repository.findAll();
    }

    public void deletePayroll(int id) {
        repository.deleteById(id);
    }
}

