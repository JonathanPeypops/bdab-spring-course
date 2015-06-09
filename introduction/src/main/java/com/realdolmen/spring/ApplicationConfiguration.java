package com.realdolmen.spring;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.service.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by cda5732 on 25/03/2015.
 */
@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfiguration.class);
        // TODO Fetch the Zoo class and print out its name and its animal count
        // TODO Test your code by running this main
        Zoo zoo = context.getBean(MyZoo.class);
        System.out.println(zoo.getName());
        System.out.println(zoo.countAnimals());

    }
}
