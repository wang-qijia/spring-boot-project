package com.sunhome.boot.autoimport.bootstrap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

/**
 * 测试ComponentScan默认扫描的范围
 */
@ComponentScan
public class ComponentScanDefaultPackageBootstrap {

    public static void main(String[] args) {
        // 当前包路径下
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanDefaultPackageBootstrap.class);


        Stream.of(context.getBeanDefinitionNames())
                .map(name -> "\t" + name)
                .forEach(System.out::println);


    }
}
