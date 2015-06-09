package com.realdolmen.spring;

import com.realdolmen.spring.domain.AwesomeMixV1;
import com.realdolmen.spring.service.Cassette;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CassetteConfig {

    public Cassette cassette(){
        return new AwesomeMixV1() {
        };
    }
}
