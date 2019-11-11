package com.sunhome.boot;

import com.sunhome.boot.formatter.autoconfigure.Formatter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;


@EnableAutoConfiguration
public class SunhomeSpringBootFirstApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SunhomeSpringBootFirstApplication.class)
                .web(WebApplicationType.NONE)  // 非 Web 应用
                .run(args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

//                System.out.println(context.getBean(ObjectMapper.class));
                Map<String, String> map = new HashMap<>();
                map.put("name", "sunhome");

                // 注释掉spring-boot-starter-web 为 bean名称:jsonFormatter,result:{"name":"sunhome"}
                Map<String, Formatter> beansOfType = context.getBeansOfType(Formatter.class);
                System.out.println(beansOfType);
                beansOfType.forEach((name, bean) -> {
                    System.out.printf("bean名称:%s,result:%s\n", name, bean.format(map));
                });

            }
        };
    }


}
