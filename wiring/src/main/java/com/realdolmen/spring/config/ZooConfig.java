package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
    @Profile("production")
    public FoodRepository foodRepository(){
        FoodRepository foodRepository = new FoodImpl();
        foodRepository.addFoodForAnimalType(Tiger.class,new MeatyFood("Zebra"));
        foodRepository.addFoodForAnimalType(Bear.class,new MeatyFood("Salmon"));
        foodRepository.addFoodForAnimalType(Elephant.class,new VegiFood("Leaves"));
        return foodRepository;
    }

    @Bean
    @Profile("test")
    public FoodRepository foodRepositoryTest(){
        FoodRepository foodRepositoryTest = new TestFoodImpl();
        foodRepositoryTest.addFoodForAnimalType(Tiger.class, new Kibble("Bacon Kibble"));
        foodRepositoryTest.addFoodForAnimalType(Bear.class, new Kibble("Fish Kibble"));
        foodRepositoryTest.addFoodForAnimalType(Elephant.class, new Kibble("Vegi Kibble"));
        return foodRepositoryTest;
    }
    // TODO Configure the FoodRepository
}
