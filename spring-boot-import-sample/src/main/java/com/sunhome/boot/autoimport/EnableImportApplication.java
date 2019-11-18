package com.sunhome.boot.autoimport;

import com.sunhome.boot.autoimport.annotation.EnableHelloWorld;
import com.sunhome.boot.autoimport.annotation.EnableSwitch;
import com.sunhome.boot.autoimport.service.FileService;
import com.sunhome.boot.autoimport.service.impl.RemoteFileServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
@EnableHelloWorld
@EnableSwitch(fileClass = RemoteFileServiceImpl.class)// 默认本地文件
@ConditionalOnNotWebApplication
public class EnableImportApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableImportApplication.class)
                .run(args)
                .close();
    }


    @Bean
    public CommandLineRunner print(ApplicationContext context) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                FileService bean = context.getBean(FileService.class);
                System.out.print("EnableSwitch:");
                bean.read();

                String helloWorld = context.getBean("helloWorld", String.class);
                System.out.println("EnableHelloWorld:" + helloWorld);

            }
        };
    }

}
