package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.Bear;
import com.realdolmen.spring.domain.Elephant;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.Tiger;
import com.realdolmen.spring.service.FoodImpl;
import com.realdolmen.spring.service.FoodRepository;
import com.realdolmen.spring.service.MyZoo;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {
    @Bean
    public Zoo zoo() {
        Zoo zoo = new MyZoo("Shark City");
        zoo.addAnimal(new Tiger("Bengal Tiger"));
        zoo.addAnimal(new Elephant("Indian Elephant"));
        zoo.addAnimal(new Bear("Brown Bear"));
        return zoo;
    }

    @Bean
    public FoodRepository foodRepository(){
        FoodRepository foodRepository = new FoodImpl();
        foodRepository.addFoodForAnimalType(Tiger.class,new Food("Zebra"));
        foodRepository.addFoodForAnimalType(Bear.class,new Food("Salmon"));
        foodRepository.addFoodForAnimalType(Elephant.class,new Food("Leafs"));
        return foodRepository;
    }
    // TODO Configure the FoodRepository
}
