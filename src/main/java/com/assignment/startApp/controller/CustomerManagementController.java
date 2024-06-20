package com.assignment.startApp.controller;

import com.assignment.startApp.entity.CustomerManagement;
import com.assignment.startApp.service.CustomerManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerManagementController {

    @Autowired
    private CustomerManagementService service;

    @PostMapping("/add")
    public CustomerManagement addCustomer(@RequestBody CustomerManagement customer) {
        return service.addCustomer(customer);
    }

    @GetMapping("/all")
    public List<CustomerManagement> getAllCustomers() {
        return service.getAllCustomers();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        service.deleteCustomers(id);
    }
}

