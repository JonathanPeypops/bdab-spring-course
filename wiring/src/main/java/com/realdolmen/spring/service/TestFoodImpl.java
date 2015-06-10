package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

import java.util.HashMap;
import java.util.Map;

public class TestFoodImpl implements  FoodRepository{

    private Map<Class<? extends Animal>, Food> foods = new HashMap<>();

    @Override
    public Food addFoodForAnimalType(Class<? extends Animal> c, Food food) {
        return foods.put(c, food);
    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> c) {
        return foods.get(c);
    }


}

