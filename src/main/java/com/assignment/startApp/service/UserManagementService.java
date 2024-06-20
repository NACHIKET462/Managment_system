package com.assignment.startApp.service;

import com.assignment.startApp.entity.UserManagement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagementService {

    private List<UserManagement> users = new ArrayList<>();

    public UserManagement addUser(UserManagement user) {
        users.add(user);
        return user;
    }

    public List<UserManagement> getAllUsers() {
        return users;
    }

    public void deleteUsers(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
