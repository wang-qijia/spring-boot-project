# spring-boot实现原理

## 读懂spring-boot前提条件是熟悉spring-framework实现原理

## spring-boot 特性
* 独立应用
* 嵌入式容器支持
* 提供starter依赖,实现自动配置
* 提供监控组件


## 构建模块
* sunhome-spring-boot 依赖-root 
    * sunhome-spring-boot-first-application demo模块 ->7
    * sunhome-spring-boot-configuration 配置模块 ->1
    * sunhome-spring-boot-import import实现模块 ->2
    * sunhome-spring-boot-alias-annotation 注解属性别名模块 ->3
    * sunhome-spring-boot-actuator 监控组件模块  ->6
    * sunhome-spring-boot-enable 自动装配模块 ->4
    * formatter-sunhome-spring-boot-starter 自定义start模块  ->5
    * sunhome-spring-boot-prometheus-simularor prometheus 客户端监控模拟器(用于埋点)  ->8

## 阅读顺序
模块 -> 数字 代表阅读顺序




    

