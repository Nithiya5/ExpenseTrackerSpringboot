package com.example.ExpenceTracker.dto;


public class AuthResponse {

    private String username;
    private String token;

    public AuthResponse(String username,String token) {
        this.username = username;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setUsername(String username) {
        this.username = username;
    }



}