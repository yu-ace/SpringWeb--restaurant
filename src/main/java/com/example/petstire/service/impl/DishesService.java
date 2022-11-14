package com.example.petstire.service.impl;

import com.example.petstire.dao.DishesDao;
import com.example.petstire.model.Dishes;
import com.example.petstire.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishesService implements IDishesService {

    @Autowired
    DishesDao dishesDao;

    @Override
    public void newDishes(String name, double price, String describe) throws Exception {
        dishesDao.newDishes(name,price,describe);
    }

    @Override
    public void deleteDishes(int id) throws Exception {
        dishesDao.deleteDishes(id);
    }

    @Override
    public List<Dishes> dishesList() throws Exception {
        List<Dishes> dishesList = dishesDao.getDishesList();
        return dishesList;
    }
}
