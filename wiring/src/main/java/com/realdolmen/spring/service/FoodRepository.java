package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

public interface FoodRepository {
    Food addFoodForAnimalType(Class<? extends Animal> c, Food food);
    Food findFoodForAnimalType(Class<? extends Animal> c);
}
