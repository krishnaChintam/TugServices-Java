package com.ship.services.controller;

import com.ship.services.pojo.LoginRequest;
import com.ship.services.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isValid = authService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword());

        if (isValid) {
            // Return 200 OK
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            // Return 500 Internal Server Error
            return new ResponseEntity<>("Invalid username or password!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
