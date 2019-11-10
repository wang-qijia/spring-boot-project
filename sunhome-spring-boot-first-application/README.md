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


```text
 com.sunhome.boot.SunhomeSpringBootFirstApplication$$EnhancerBySpringCGLIB$$9b80c564@71cb3139
```






  
    
