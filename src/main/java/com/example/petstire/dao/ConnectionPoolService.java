package com.example.petstire.dao;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

@Service
public class ConnectionPoolService {
    String url = "jdbc:mysql://192.168.50.252:3306/pet";
    String user = "root";
    String password = "123456";
    String className = "com.mysql.cj.jdbc.Driver";
    int minNumber = 3;
    int createNumber = 5;
    int maxFreeNumber = 8;
    int maxConnectionNumber = 60;

    private List<Connection> userConnectionList = new LinkedList<>();
    private Deque<Connection> freeConnectionList = new LinkedList<>();


    public Connection open() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        freeConnectionList.add(connection);
        return connection;
    }

    public ConnectionPoolService() throws Exception {
        Class.forName(className);
        for(int i = 0;i < createNumber;i++){
            open();
        }
    }

    public Connection getConnection() throws Exception {
        if(freeConnectionList == null && freeConnectionList.size() + userConnectionList.size() == maxConnectionNumber){
            throw new Exception("连接池无空余连接");
        }
        if(freeConnectionList.size() < minNumber){
            open();
        }else{
            removeFreeConnection();
        }
        Connection connection = freeConnectionList.removeFirst();
        userConnectionList.add(connection);
        return connection;
    }

    public void returnConnection(Connection connection) {
        userConnectionList.remove(connection);
        freeConnectionList.add(connection);
    }

    public void removeFreeConnection(){
        if(freeConnectionList.size() > maxFreeNumber){
            for(int i = 0;i < createNumber;i++){
                Connection connection = freeConnectionList.removeFirst();
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
