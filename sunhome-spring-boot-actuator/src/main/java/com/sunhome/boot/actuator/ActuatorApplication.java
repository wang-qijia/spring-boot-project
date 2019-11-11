package com.sunhome.boot.actuator;


import com.sunhome.boot.actuator.endpoint.CustomEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }


    @Bean
    public CustomEndpoint customEndpoint() {
        return new CustomEndpoint();
    }


}
