package com.sunhome.boot.context;

import com.sunhome.boot.context.event.ConfigChangeAnnotationListener;
import com.sunhome.boot.context.event.ConfigChangeEvent;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

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
                .bannerMode(Banner.Mode.OFF)
                .run(args);

       // localTest();


    }

    private static void localTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.registerBean(ConfigChangeAnnotationListener.class);

        context.refresh();

        Map<String, Object> configMap = new HashMap<>();
        configMap.put("name", "lisha");
        configMap.put("age", "18");
        context.publishEvent(new ConfigChangeEvent(configMap));

        context.close();
    }
}
