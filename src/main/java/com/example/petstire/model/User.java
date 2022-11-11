package com.example.petstire.model;

import org.springframework.stereotype.Service;

@Service
public class User {
    String name;
    int password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
