package com.assignment.startApp.Models;

import java.util.List;

public class UserDetailsResponse {

    private int id;
    private String username;
    private String email;
    private int role;

    private List<FunctionalityAccessResponse> functionalityAccessList;

    public List<FunctionalityAccessResponse> getFunctionalityAccessList() {
        return functionalityAccessList;
    }

    public void setFunctionalityAccessList(List<FunctionalityAccessResponse> functionalityAccessList) {
        this.functionalityAccessList = functionalityAccessList;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}

