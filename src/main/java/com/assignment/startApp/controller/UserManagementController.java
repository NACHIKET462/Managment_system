package com.assignment.startApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assignment.startApp.entity.UserManagement;
import com.assignment.startApp.service.UserManagementService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserManagementController {

    @Autowired
    private UserManagementService service;

    @PostMapping("/add")
    public UserManagement addUser(@RequestBody UserManagement user) {
        return service.addUser(user);
    }

    @GetMapping("/all")
    public List<UserManagement> getAllUsers() {
        return service.getAllUsers();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        service.deleteUsers(id);
    }
}
