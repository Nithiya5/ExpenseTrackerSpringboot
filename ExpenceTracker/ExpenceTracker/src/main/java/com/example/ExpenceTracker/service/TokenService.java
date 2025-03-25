package com.example.ExpenceTracker.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {
    private Map<String,String> tokenStoreSessionHashmap = new HashMap<>();

    public String generateToken(String username){
        String token = UUID.randomUUID().toString();
        tokenStoreSessionHashmap.put(username,token);
        return token;
    }

    public boolean isValidToken(String username,String token){
        if(tokenStoreSessionHashmap.containsKey(username)){
            return token.equalsIgnoreCase(tokenStoreSessionHashmap.get(username));
        }
        return false;
    }
}