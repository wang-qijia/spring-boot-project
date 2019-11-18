package com.sunhome.boot.context;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author wangqijia
 * @date 2019/11/18 12:53
 */
@EnableAsync
@SpringBootApplication
public class EventBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(EventBootstrap.class)
                .run(args);


    }
}
