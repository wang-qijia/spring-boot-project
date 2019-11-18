# spring-boot context 事件驱动模块

## SpringApplication 应用进程 生命周期
* 初始化阶段 SpringApplication#261行
* 运行阶段 
* 结束阶段
* 应用退出


## 事件驱动构成成员
* 事件源
    1. 实现ApplicationEvent自定义事件类型
* 事件发布者
    1. 注入 ApplicationEventPublisher
    2. impl ApplicationEventPublisherAware 接口
    3   ApplicationContext.publishEvent();
* 事件监听者
    1. implements ApplicationListener<事件源>
    2. @EventListener 
    3. 默认同步监听机制,可以@EnableAsync 开启异步支持

## 事件驱动作用
1. 业务之间解耦,可以在不改变代码前提下为业务扩展功能
2. 单进程内可以采用Spring事件达到业务上的解耦,多进程可以采用mq
3. 逻辑结构上更加清晰

## 进一步详细了解事件驱动
* spring-cloud-stream 参考该模块怎样做到屏蔽厂商Api细节,达到模块之间解耦


## 源码位置
spring-boot:2.0.2RELEASE 模块


## 参考文章
spring boot run 启动过程逻辑的演变
[https://github.com/chanjarster/spring-boot-all-callbacks](https://github.com/chanjarster/spring-boot-all-callbacks)



    

