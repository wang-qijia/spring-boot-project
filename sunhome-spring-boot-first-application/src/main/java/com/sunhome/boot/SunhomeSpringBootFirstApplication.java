package com.sunhome.boot;

import com.sunhome.boot.annotation.EnableHelloWorld;
import com.sunhome.boot.config.TestConfiguration;
import com.sunhome.boot.entiy.BeanTest;
import com.sunhome.boot.service.TransactionalServiceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

@RestController
@EnableHelloWorld
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//@EnableTransactionManagement
public class SunhomeSpringBootFirstApplication {

    public static void main(String[] args) {
        // ConfigurableApplicationContext applicationContext = SpringApplication.run(SunhomeSpringBootFirstApplication.class, args);
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SunhomeSpringBootFirstApplication.class);
//
//        TransactionalServiceBean bean = context.getBean(TransactionalServiceBean.class);
//        bean.save();


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
