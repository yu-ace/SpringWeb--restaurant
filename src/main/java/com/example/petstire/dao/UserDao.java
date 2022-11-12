package com.example.petstire.dao;

import com.example.petstire.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class UserDao {
    @Autowired
    ConnectionPoolService connectionPoolService;

    public void register(String name, String password) throws Exception {
            String str = "insert into user (username,password) values('%s',%d);";
            String sqlStr = String.format(str,name,password);
            Connection connection = connectionPoolService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPoolService.returnConnection(connection);
    }

    public User getUser(String username) throws Exception {
        try{
            String str = "select * from user where username = '%s'";
            String sqlStr = String.format(str,username);
            Connection connection = connectionPoolService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()) {
                return null;
            }else{
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User();
                user.setName(name);
                user.setPassword(password);
                connectionPoolService.returnConnection(connection);
                return user;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
