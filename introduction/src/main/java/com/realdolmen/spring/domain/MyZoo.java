package com.realdolmen.spring.domain;


import com.realdolmen.spring.service.Zoo;

import java.util.ArrayList;

public class MyZoo implements Zoo{
    private String zooName;
    private ArrayList<Animal> animalList = new ArrayList<>();

    public MyZoo(String zooName) {
        this.zooName = zooName;
    }

    public String getZooName() {
        return zooName;
    }

    @Override
    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {

    }

    @Override
    public boolean accept(Visitor visitor) {
        return false;
    }

    @Override
    public String getName() {
        return zooName;
    }

    @Override
    public int countAnimals() {
        return animalList.size();
    }
}
