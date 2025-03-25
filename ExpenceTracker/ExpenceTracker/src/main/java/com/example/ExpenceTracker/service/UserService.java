package com.example.ExpenceTracker.service;

import com.example.ExpenceTracker.entity.User;
import com.example.ExpenceTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    public String signup(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return "Username already exists";
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return "User registered successfully";
    }
}
