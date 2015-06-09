package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodDistributionServiceImpl implements FoodDistributionService {
    @Autowired
    private FoodRepository foodRepository;
    @Override
    public void feedAnimalsByType(List<Animal> animals) {
        for (Animal animal : animals){
            Food f = foodRepository.findFoodForAnimalType(animal.getClass());
            animal.feed(f);
        }
    }
}
