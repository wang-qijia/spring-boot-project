package com.sunhome.boot;

import com.sunhome.boot.annotation.EnableSwitch;
import com.sunhome.boot.service.FileService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwitch(open = true)
public class EnableSwitchBootstrap {

    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(EnableSwitchBootstrap.class);
//        FileService fileService = configApplicationContext.getBean(FileService.class);
//
//        fileService.read();
    }
}
