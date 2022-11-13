package com.example.petstire.controller;


import com.example.petstire.model.User;
import com.example.petstire.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    public IUserService userService;

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String register(
            @RequestParam(name = "username")
            String name,
            @RequestParam(name = "password")
            String password) throws Exception {
        userService.newUser(name, password);
        return "注册成功!";
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(
            @RequestParam(name = "username")
            String name,
            @RequestParam(name = "password")
            String password) throws Exception {
        User user = userService.getUser(name);
        if(user == null){
            return "账户不存在";
        }
        if(user.getName().equals(name)){
            if(user.getPassword().equals(password)){
                return "登陆成功";
            }else{
                return "密码错误";
            }
        }
        return null;
    }



}
