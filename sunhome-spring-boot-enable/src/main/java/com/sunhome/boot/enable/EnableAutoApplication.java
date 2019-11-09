package com.sunhome.boot.enable;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ConditionalOnNotWebApplication
public class EnableAutoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableAutoApplication.class)
                .run(args)
                .close();
    }


    @Bean
    public CommandLineRunner print(ApplicationContext context) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        };
    }

}
