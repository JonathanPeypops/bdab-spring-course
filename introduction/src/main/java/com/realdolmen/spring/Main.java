package com.realdolmen.spring;

import com.realdolmen.spring.service.Cassette;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CassetteConfig.class);
        context.getBean(Cassette.class).play();
    }
}
