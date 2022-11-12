package com.example.petstire.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public interface IConnectionPoolService {
    Connection getConnection() throws Exception;
    void returnConnection(Connection connection);
}
