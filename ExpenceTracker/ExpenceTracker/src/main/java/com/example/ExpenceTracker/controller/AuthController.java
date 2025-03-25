package com.example.ExpenceTracker.controller;


import com.example.ExpenceTracker.dto.AuthResponse;
import com.example.ExpenceTracker.service.TokenService;
import com.example.ExpenceTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader String username, @RequestHeader String password) {
        boolean isValid = checkCredentialsInDatabase(username, password);
        if (isValid) {
            String token = tokenService.generateToken(username);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AuthResponse(username, token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestHeader String username, @RequestHeader String password) {
        String response = userService.signup(username, password);
        if (response.equals("User registered successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    private boolean checkCredentialsInDatabase(String username, String password) {
            return userService.login(username, password);
    }

}