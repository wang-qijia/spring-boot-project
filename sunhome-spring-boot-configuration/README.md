# spring-boot 外部化配置


## 常用属性配置优先级
1. 命令行参数 jar -server.port
2. java 的系统属性 System.setProperties()
3. application.yml 通过spring.profiles.active区分环境

## 常用属性注入注解
* @value
* @ConfigurationProperties
* implements EnvironmentAware


## 自动配置
resources\META-INF/spring.factories 加入自动配置类名全路径

## 自动提示工具
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
```
生成文件:target/classes/META-INF\spring-configuration-metadata.json 这个文件提供自动提示索引功能

## 源码剖析
1. AbstractAutowireCapableBeanFactory->applyBeanPostProcessorsBeforeInitialization
2. ConfigurationPropertiesBindingPostProcessor->postProcessBeforeInitialization


后期补充...


