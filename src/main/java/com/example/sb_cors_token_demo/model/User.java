package com.example.sb_cors_token_demo.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
