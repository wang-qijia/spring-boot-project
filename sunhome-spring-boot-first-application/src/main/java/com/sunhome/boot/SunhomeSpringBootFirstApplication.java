package com.sunhome.boot;

import com.sunhome.boot.config.TestConfiguration;
import com.sunhome.boot.entiy.BeanTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public BeanTest beanTest() {
        return new BeanTest();
    }

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                try {
                    System.out.println(beanFactory.getBean(TestConfiguration.class));
                } catch (BeansException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
