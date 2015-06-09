package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {
    @Bean
    public MyZoo myzoo(){
        MyZoo z = new MyZoo("Shark City");
        z.addAnimal(lion());
        z.addAnimal(bear());
        z.addAnimal(shark());
        return z;
    }

    @Bean
    public Animal lion(){
        return new Lion("Karel");
    }

    @Bean
    public Animal bear(){
        return new Bear("Teddy");
    }

    @Bean
    public Animal shark(){
        return new Shark("Fred");
    }
}
