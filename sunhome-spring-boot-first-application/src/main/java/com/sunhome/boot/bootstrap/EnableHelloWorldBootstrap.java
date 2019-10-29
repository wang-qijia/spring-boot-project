package com.sunhome.boot.bootstrap;

import com.sunhome.boot.annotation.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(EnableHelloWorldBootstrap.class);


        String helloWorld = configApplicationContext.getBean("helloWorld", String.class);

        System.out.println(helloWorld);
    }
}
