package com.assignment.startApp.service;

import com.assignment.startApp.entity.CustomerManagement;
import com.assignment.startApp.repository.CustomerManagementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagementService {

    @Autowired
    private CustomerManagementRepository repository;

    public CustomerManagement addCustomer(CustomerManagement customer) {
        return repository.save(customer);
    }

    public List<CustomerManagement> getAllCustomers() {
        return repository.findAll();
    }
    public void deleteCustomers(int id) {
        repository.deleteById(id);
    }
}

