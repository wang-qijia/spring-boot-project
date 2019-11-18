# spring-boot @Enable 自动装配模块

## 实现方式
META-INF/spring.factories 添加配置的类全路径
META-INF/spring-autoconfigure-metadata.properties 添加配置类的条件匹配信息
META-INF/spring-configuration-metadata.json 添加配置类的属性的元信息
参考:spring-boot-autoconfigure\2.0.2.RELEASE\spring-boot-autoconfigure-2.0.2.RELEASE.jar


## 排序自动装配组件
1. @AutoConfigureBefore
2. @AutoConfigureAfter

## 为什么自定义配置覆盖自动装配的配置
* DeferredImportSelector importSelector的子类，延迟加载晚于自定义配置后

## 实现原理
1. SpringFactoriesLoader.loadFactoryNames() 加载配置文件返回实现类的全类名列表
2. 去重并排除自动装配的名单
3. 再次过滤自动装配的class集合中class不存在的成员(@conditionOn起的作用)
4. 触发自动装配的事件


## 源码解析
ConfigurationClassPostProcessor 后置处理类
AutoConfigurationImportSelector 自动加载配置类
AutoConfigurationMetadataLoader 自动加载配置类元信息
AutoConfigurationImportListener 自动装配监听器

如有不足，后续补充....




