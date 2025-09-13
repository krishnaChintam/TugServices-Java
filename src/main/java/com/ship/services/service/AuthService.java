package com.ship.services.service;

import com.ship.services.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean validateLogin(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPasswordHash()))
                .orElse(false);
    }
}
