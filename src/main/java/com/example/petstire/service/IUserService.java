package com.example.petstire.service;

import com.example.petstire.model.User;
import org.springframework.stereotype.Service;


public interface IUserService {
    void newUser(String name,String password) throws Exception;
    User getUser(String name) throws Exception;
}
