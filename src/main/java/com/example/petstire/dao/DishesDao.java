package com.example.petstire.dao;

import com.example.petstire.model.Dishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Component
public class DishesDao {

    @Autowired
    ConnectionPool connectionPool;

    List<Dishes> dishesList = new ArrayList<>();

    public void newDishes(String name,double price,String describe) throws Exception {
        String str = "insert into dishes (name,price,`describe`) values ('%s','%.2f','%s');";
        String sqlStr = String.format(str,name,price,describe);
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.execute();
        connectionPool.returnConnection(connection);
    }

    public List<Dishes> getDishesList() throws Exception {
        String sqlStr = "select * from dishes where on = 1;";
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String describe = resultSet.getString("describe");
            Dishes dishes = new Dishes();
            dishes.setId(id);
            dishes.setName(name);
            dishes.setPrice(price);
            dishes.setDescribe(describe);
            dishesList.add(dishes);
        }
        connectionPool.returnConnection(connection);
        return dishesList;
    }

    public void deleteDishes(int id) throws Exception {
        String str = "update dishes on = 2 where id = %d;";
        String sqlStr = String.format(str,id);
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.execute();
        connectionPool.returnConnection(connection);
    }

}
