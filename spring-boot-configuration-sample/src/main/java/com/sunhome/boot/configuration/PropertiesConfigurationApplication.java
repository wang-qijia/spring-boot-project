package com.sunhome.boot.configuration;

import com.sunhome.boot.configuration.config.properties.EnvironmentProperties;
import com.sunhome.boot.configuration.config.properties.SunHomeProperties;
import com.sunhome.boot.configuration.config.properties.ValueProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.sunhome.boot")
@EnableAutoConfiguration
@ConditionalOnNotWebApplication
public class PropertiesConfigurationApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(PropertiesConfigurationApplication.class)
                .run(args);


    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                SunHomeProperties bean = applicationContext.getBean(SunHomeProperties.class);
                System.out.println("sunHomeProperties:" + bean.getSys().getName());

                ValueProperties value = applicationContext.getBean(ValueProperties.class);
                System.out.println("value:" + value.toString());

                EnvironmentProperties env = applicationContext.getBean(EnvironmentProperties.class);
                System.out.println("env:" + env.getName());

                System.out.println("方法参数注入:" + applicationContext.getBean("test", String.class));

            }
        };
    }
}
