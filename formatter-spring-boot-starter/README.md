# spring boot starter 自定义


## 官方推荐命名规范
1. 项目模块命名: ${module}-spring-boot-starter
2. 项目包命名:
    1. 多模块
        * ${root-package} 根包名 
            * autoconfigure 
                * ${module-package} 例如:web
                    * *AutoConfiguration 
                    * ${sub-module-package} 子模块
                        * other-class
                * ${module-package} 例如:aop
                   * *AutoConfiguration 
                        * ${sub-module-package} 子模块
                            * other-class
    2. 单模块 (本项目采用这种)
        * ${root-package} 根包名 
            * ${module-package}
                * autoconfigure                    
                    * *AutoConfiguration 
                    * ${sub-module-package} 子模块
                        * other-class
                * 其他辅助模块
                * 其他类

3. Class命名规范:*AutoConfiguration 
4. 官方建议将自动装配代码存放在autoconfigure模块中,starter模块依赖该模块,但是开发者完全可以将两者合并到单模块jar中
4. 可以参考 WebMvcAutoConfiguration 包命名结构

## 自动装配候选类排序
* @AutoConfigureAfter
* @AutoConfigureOrder
* @AutoConfigureBefore
* 此路径下 resources\META-INF\spring-autoconfigure-metadata.properties 配置元信息，减少自动装配的时间(默认先读配置文件不存在读类元注解信息)

## 本项目采用单模块制
    相关业务代码在starter模块中编写
    测试项目模块见sunhome-spring-boot-first-application
    
    
## 项目依赖
```xml
        <dependency>
            <groupId>com.sunhome.boot</groupId>
            <artifactId>formatter-sunhome-spring-boot-starter</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
```
该项目所有引入依赖设置true避免依赖传递
```xml
    <optional>true</optional>
```
## 源码解析
AutoConfigurationSorter 排序逻辑类

## 参考代码
[https://github.com/apache/dubbo-spring-boot-project](https://github.com/apache/dubbo-spring-boot-project)

[https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#boot-features-custom-starter-naming](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#boot-features-custom-starter-naming)

