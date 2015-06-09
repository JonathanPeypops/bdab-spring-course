package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MyZoo implements Zoo {
    @Autowired
    private FoodDistributionServiceImpl foodDistributionService;
    private String name;
    private List<Animal> animals = new ArrayList<>();

    public MyZoo() {
    }

    // TODO fetch the FoodDistributionService

    public MyZoo(String name) {
        this.name = name;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public boolean accept(Visitor visitor) {
        System.out.println("Welcome visitor to " + getName());
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }

    @Override
    public void feedAnimals() {
        foodDistributionService.feedAnimalsByType(animals);
    }

    // TODO Call the FoodDistributionService to feed animals


}
