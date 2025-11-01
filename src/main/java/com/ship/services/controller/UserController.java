package com.ship.services.controller;

import com.ship.services.model.UserEntity;
import com.ship.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserEntity> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error retrieving users: " + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long userId) {
        try {
            return userService.getUserById(userId)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error getting user: " + ex.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long userId,
                                        @RequestBody UserEntity userDetails) {
        try {
            UserEntity updatedUser = userService.updateUser(userId, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error updating user: " + ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        try {
            if (userEntity.getUsername() == null || userEntity.getPasswordHash() == null) {
                throw new IllegalArgumentException("Username and Password are required.");
            }
            UserEntity createdUser = userService.createUser(userEntity);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error creating user: " + ex.getMessage());
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error deleting user: " + ex.getMessage());
        }
    }
}