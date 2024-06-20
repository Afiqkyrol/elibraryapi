package com.example.elibrary.model;

import java.util.Collection;

public class AuthenticationResponse {
    private String token;
    private Collection authorities;
    private String username;

    private int user_id;

    private String fullName;

    public AuthenticationResponse(String token, Collection authorities, String username, int userId, String fullName) {
        this.token = token;
        this.authorities = authorities;
        this.username = username;
        user_id = userId;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public Collection getAuthorities() {
        return authorities;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getFullName() {
        return fullName;
    }
}
