package com.assignment.startApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.startApp.Models.FunctionalityAccessResponse;
import com.assignment.startApp.Models.UserDetailsResponse;
import com.assignment.startApp.entity.LoginRequest;
import com.assignment.startApp.entity.RoleFunctionalityAccess;
import com.assignment.startApp.entity.User;
import com.assignment.startApp.repository.RoleFunctionalityAccessRepository;
import com.assignment.startApp.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleFunctionalityAccessRepository roleFunctionalityAccessRepository;

    

    @PostMapping("/save")
    public User save(@RequestBody User user){
       return userService.saveUser(user);
    }

    @GetMapping("/GetAll")
    public List<User> findAll() {
        return userService.findAll();
    }

   @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam int id) {
        try {
            // Find user by ID
            User user = userService.findById(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            // Prepare UserDetailsResponse with basic user details
            UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
            userDetailsResponse.setId(user.getId());
            userDetailsResponse.setUsername(user.getUsername());
            userDetailsResponse.setEmail(user.getEmail());
            userDetailsResponse.setRole(user.getRole_id());

            // Fetch role functionality access details based on role_id
            List<RoleFunctionalityAccess> accessList = roleFunctionalityAccessRepository.findByRoleId(user.getRole_id());

            // Prepare functionality access response list
            List<FunctionalityAccessResponse> functionalityAccessList = new ArrayList<>();
            for (RoleFunctionalityAccess access : accessList) {
                FunctionalityAccessResponse accessResponse = new FunctionalityAccessResponse();
                accessResponse.setFunctionalityId(access.getFunctionalityId());
                accessResponse.setAccessType(access.getAccessType());
                functionalityAccessList.add(accessResponse);
            }

            // Set functionality access list in userDetailsResponse
            userDetailsResponse.setFunctionalityAccessList(functionalityAccessList);

            return ResponseEntity.ok(userDetailsResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving user details");
        }
    }


    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteById")
    public void delete(@RequestParam int id){
        userService.deleteUser(id);
    }
    
 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        try {
            User authenticatedUser = userService.findByEmailAndPassword(email, password)
                    .orElseThrow(() -> new RuntimeException("Incorrect email or password"));

            System.out.println("Authenticated User: " + authenticatedUser);

            // Prepare UserDetailsResponse with basic user details
            UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
            userDetailsResponse.setId(authenticatedUser.getId());
            userDetailsResponse.setUsername(authenticatedUser.getUsername());
            userDetailsResponse.setEmail(authenticatedUser.getEmail());

            // Fetch role functionality access details based on role_id
            List<RoleFunctionalityAccess> accessList = roleFunctionalityAccessRepository.findByRoleId(authenticatedUser.getRole_id());

            // Prepare functionality access response list
            List<FunctionalityAccessResponse> functionalityAccessList = new ArrayList<>();
            for (RoleFunctionalityAccess access : accessList) {
                FunctionalityAccessResponse accessResponse = new FunctionalityAccessResponse();
                accessResponse.setFunctionalityId(access.getFunctionalityId());
                accessResponse.setAccessType(access.getAccessType());
                functionalityAccessList.add(accessResponse);
            }

            // Set functionality access list in userDetailsResponse
            userDetailsResponse.setFunctionalityAccessList(functionalityAccessList);

            return ResponseEntity.ok(userDetailsResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Authentication failed: " + e.getMessage());
        }
    }

}
