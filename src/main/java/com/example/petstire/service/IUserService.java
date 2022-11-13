package com.example.petstire.service;

import com.example.petstire.model.User;


public interface IUserService {
    void newUser(String name,String password) throws Exception;
    User getUser(String name) throws Exception;
}
