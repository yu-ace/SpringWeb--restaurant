package com.example.petstire.service.impl;

import com.example.petstire.dao.UserDao;
import com.example.petstire.model.User;
import com.example.petstire.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public void newUser(String name, String password) throws Exception {
        userDao.register(name,password);
    }

    @Override
    public User getUser(String name) throws Exception {
        User user = userDao.getUser(name);
        return user;
    }


}
