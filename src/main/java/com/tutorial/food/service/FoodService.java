package com.tutorial.food.service;

import com.tutorial.food.mapper.FoodMapper;
import com.tutorial.food.model.Food;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    private FoodMapper foodMapper;

    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public int addFood(Food food) {
        return foodMapper.insertFood(food);
    }

    public Food[] getFoods() {
//        Food[] foods = {new Food("Pizza", 6.9), new Food("Rice Bowl", 7.5), new Food("Soda", 2.0)};
        Food[] foods = foodMapper.selectFoods();
        return foods;
    }
}
