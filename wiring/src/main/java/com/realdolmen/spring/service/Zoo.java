package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;

public interface Zoo {

    int maxAnimal (int i);

    String ownerName (String s);

    double ticketPrice (double d);


    void addAnimal(Animal animal);

    void releaseAnimal(Animal animal);

    boolean accept(Visitor visitor);

    String getName();

    int countAnimals();

    void feedAnimals();

    // TODO add method to feed animals
}
