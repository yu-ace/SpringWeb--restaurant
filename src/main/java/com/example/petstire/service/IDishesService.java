package com.example.petstire.service;

import com.example.petstire.model.Dishes;

import java.util.List;

public interface IDishesService {
    void newDishes(String name,double price,String describe) throws Exception;
    void deleteDishes(int id) throws Exception;
    List<Dishes> dishesList() throws Exception;
}
