package com.example.petstire.controller;

import com.example.petstire.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishesController {

    @Autowired
    public IDishesService dishesService;

    @RequestMapping(path="/newDishes",method = RequestMethod.POST)
    public String newDishes(
            @RequestParam(name = "name")
            String name,
            @RequestParam(name = "price")
            double price,
            @RequestParam(name = "describe")
            String describe) throws Exception {
        dishesService.newDishes(name,price,describe);
        return "添加成功";
    }

}
