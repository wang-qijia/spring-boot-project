package com.sunhome.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SunhomeSpringBootFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunhomeSpringBootFirstApplication.class, args);
    }

    @GetMapping("index")
    public String index() {
        System.out.println(Thread.currentThread().getName());
        return "index";
    }

}
