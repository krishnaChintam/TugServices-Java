package com.ship.services.service;

import com.ship.services.model.UserEntity;
import com.ship.services.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Added for best practice

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ➕ CREATE (New User Creation)
    @Transactional
    public UserEntity createUser(UserEntity userEntity) {
        try {
            if (userRepository.findByUsername(userEntity.getUsername()).isPresent()) {
                throw new IllegalArgumentException("Username '" + userEntity.getUsername() + "' is already taken.");
            }

            // Hash password before saving
            String encodedPassword = passwordEncoder.encode(userEntity.getPasswordHash());
            userEntity.setPasswordHash(encodedPassword);

            // Set mandatory audit fields
            userEntity.setCreateDate(LocalDateTime.now());
            userEntity.setCreateBy("Admin");

            return userRepository.save(userEntity);
        } catch (Exception ex) {
            // Re-throw as RuntimeException so the Controller can catch it
            throw new RuntimeException("Error creating user: " + ex.getMessage(), ex);
        }
    }

    // 🔍 READ ALL (Get all users)
    public List<UserEntity> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Error retrieving users: " + ex.getMessage(), ex);
        }
    }

    // 🔎 READ BY ID (Get user by ID)
    public Optional<UserEntity> getUserById(Long id) {
        try {
            return userRepository.findById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error getting user by ID " + id + ": " + ex.getMessage(), ex);
        }
    }

    // 🔄 UPDATE
    @Transactional
    public UserEntity updateUser(Long id, UserEntity userDetails) {
        try {
            UserEntity user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            user.setTugName(userDetails.getTugName());
            user.setIsActive(userDetails.getIsActive());
            user.setEditedDate(LocalDateTime.now());
            user.setEditedBy("Admin");
            user.setNoOfHours(userDetails.getNoOfHours());
            user.setPackageCost(userDetails.getPackageCost());
            user.setPerHourCost(userDetails.getPerHourCost());

            // Only update password if a new one is provided
            if (userDetails.getPasswordHash() != null && !userDetails.getPasswordHash().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(userDetails.getPasswordHash());
                user.setPasswordHash(encodedPassword);
            }

            return userRepository.save(user);
        } catch (Exception ex) {
            // Check if the original exception is a simple RuntimeException (like 'Not found')
            if (ex instanceof RuntimeException && ex.getCause() == null) {
                throw ex; // Preserve "User not found" message
            }
            throw new RuntimeException("Error updating user with ID " + id + ": " + ex.getMessage(), ex);
        }
    }

    // ❌ DELETE
    @Transactional
    public void deleteUser(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new RuntimeException("User not found with ID: " + id);
            }
            userRepository.deleteById(id);
        } catch (Exception ex) {
            // Check if the original exception is a simple RuntimeException (like 'Not found')
            if (ex instanceof RuntimeException && ex.getCause() == null) {
                throw ex; // Preserve "User not found" message
            }
            throw new RuntimeException("Error deleting user with ID " + id + ": " + ex.getMessage(), ex);
        }
    }
}