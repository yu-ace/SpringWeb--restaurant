package com.example.petstire.dao;


import com.example.petstire.model.User;
import com.example.petstire.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDao {

    @Autowired
    public IUserService userService;

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String register(
            @RequestParam(name = "username")
            String name,
            @RequestParam(name = "password")
            int password){
        userService.newUser(name, password);
        return "注册成功";
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(
            @RequestParam(name = "username")
            String name,
            @RequestParam(name = "password")
            int password){
        List<User> userList = userService.getUserList();
        for(User user : userList){
            if(user.getName().equals(name)){
                if(user.getPassword() == password){
                    return "登陆成功";
                }else{
                    return "密码错误,登陆失败";
                }
            }
        }
        return "用户名不存在";
    }

}
