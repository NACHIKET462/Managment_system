package com.assignment.startApp.Models;

import java.util.List;

public class RoleDetailsResponse {

    private int id;
    private String name;
    private List<FunctionalityAccessResponse> functionalityAccessList; // <-- Adjusted name

    // Constructor
    public RoleDetailsResponse() {
        // Constructor
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FunctionalityAccessResponse> getFunctionalityAccessList() {
        return functionalityAccessList;
    }

    public void setFunctionalityAccessList(List<FunctionalityAccessResponse> functionalityAccessList) {
        this.functionalityAccessList = functionalityAccessList;
    }
}
