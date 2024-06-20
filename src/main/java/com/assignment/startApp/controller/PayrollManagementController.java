package com.assignment.startApp.controller;

import com.assignment.startApp.entity.PayrollManagement;
import com.assignment.startApp.service.PayrollManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payroll")
public class PayrollManagementController {

    @Autowired
    private PayrollManagementService service;

    @PostMapping("/add")
    public PayrollManagement addPayroll(@RequestBody PayrollManagement payroll) {
        return service.addPayroll(payroll);
    }

    @GetMapping("/all")
    public List<PayrollManagement> getAllPayrolls() {
        return service.getAllPayrolls();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        service.deletePayroll(id);
    }
    
}
