package com.sunhome.boot.autoimport.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "helloWorld";

    }
}
