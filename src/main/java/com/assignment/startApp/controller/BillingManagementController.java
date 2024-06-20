package com.assignment.startApp.controller;

import com.assignment.startApp.entity.BillingManagement;
import com.assignment.startApp.service.BillingManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/billing")
public class BillingManagementController {

    @Autowired
    private BillingManagementService service;

    @PostMapping("/add")
    public BillingManagement addBillingManagement(@RequestBody BillingManagement billingManagement) {
        return service.addBillingManagement(billingManagement);
    }

    @GetMapping("/all")
    public List<BillingManagement> getAllBillingManagements() {
        return service.getAllBillingManagements();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        service.deleteBill(id);
    }
}
