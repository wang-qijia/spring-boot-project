# spring-boot parse模块

## 执行方法
* 生产环境: java -jar 
* 开发环境:mvn spring-boot:run 或Main方法运行

## 引导类依赖 
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-loader</artifactId>
        <version>2.0.1.RELEASE</version>
        <scope>provided</scope>
    </dependency>
```

##引导全类名
* MANIFEST.IF
    * Main-Class:org.springframework.boot.load.JarLauncher
    * Start-Class: 引导类Main
     
    

## 依赖管理
   spring boot 利用maven的依赖管理特性,固化了maven依赖
目前官网维护:spring-boot-starter-parent和spring-boot-dependencies 两个依赖管理项目

## @Bean注入区别
  * @Bean在@Component或普通类中声明一样,注册导spring应用的上下文中,不存在CGLIB增强处理,
  * @Bean在@Configuration中声明做了CGLIB处理 

```text
 com.sunhome.boot.SunhomeSpringBootFirstApplication$$EnhancerBySpringCGLIB$$9b80c564@71cb3139
```

## 生产监控组件
* spring boot actuator作用   
    * 监控检查
    * 应用监控
    * 指标收集
* 默认端口
    * /actuator/health
     * /actuator/env
    



## spring 注解模式
* 元注解 @Component (ContextNamespaceHandler 处理器)
* 模式注解 @Component派生注解 @Service @Controller
* 组合注解 @SpringBootApplication
* 注解属性别名和覆盖
    1. 隐性覆盖 
        * @Component
            * @Service -> 底层注解覆盖高层注解属性
   2. 显性覆盖
        *     @AliasFor(
                  annotation = ComponentScan.class,
                  attribute = "basePackages"
              )
              String[] scanBasePackages() default {};
              通过@AliasFor显性覆盖ComponentScan-basePackages属性,目的更加见名识意
   3. 处理工具类:AnnotationAttributes.getMergedAnnotationAttributes()  
 




  
    
