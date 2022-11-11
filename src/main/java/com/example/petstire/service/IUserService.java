package com.example.petstire.service;

import com.example.petstire.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    void newUser(String name,int password);
    List<User> getUserList();
}
