package com.ship.services.controller;

import com.ship.services.model.UserEntity;
import com.ship.services.pojo.LoginRequest;
import com.ship.services.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<UserEntity> userOpt = authService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword());

        if (userOpt.isPresent()) {
            if(userOpt.get().getIsActive() == 0){
                return new ResponseEntity<>("User account is inactive.Please contact admin", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity<>(userOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password!", HttpStatus.UNAUTHORIZED);
        }
    }

}
