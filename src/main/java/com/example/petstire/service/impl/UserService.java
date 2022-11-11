package com.example.petstire.service.impl;

import com.example.petstire.model.User;
import com.example.petstire.service.IUserService;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private static IUserService userService;

    private UserService(){
    }
    public static IUserService getInstance(){
        return userService;
    }

    List<User> userList = new ArrayList<>();
    @Override
    public void newUser(String name, int password){
        try {
            String str = "insert into user (username,password) values('%s',%d);";
            String sqlStr = String.format(str,name,password);
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.50.252:3306/pet","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUserList(){
        try{
            String sqlStr = "select * from user;";
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.50.252:3306/pet","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String username = resultSet.getString("username");
                int password1 = resultSet.getInt("password");
                User user = new User();
                user.setName(username);
                user.setPassword(password1);
                userList.add(user);
            }
            connection.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


}
