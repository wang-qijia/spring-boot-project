# spring-boot @import使用


## 实现方式
* 注解驱动
    1. @import导入@configuration标注的类注册到容器中
* 接口编程
    1. 实现 importSelector 返回类全路径，由框架注册到容器
    2. 实现 importBeanDefinitionRegistrar 获取类全路径，开发者自己实现诸如到容器
    3. 实现 DeferredImportSelector 实现延迟加载，自动装配的核心


## @Bean注入区别
  * @Bean在@Component或普通类中声明一样,注册导spring应用的上下文中,不存在CGLIB增强处理,
  * @Bean在@Configuration中声明做了CGLIB处理 
  * spring 将@configuration成为完全模式，@Component为轻量模式

## 注解驱动bean注册方式
* @ComponentScan 模式扫描注解
* @Component,@Bean,@Configuration 注解注册
* @AnnotationConfigApplicationContext 编程时注册

## 源码剖析
1. configurationClassParser->parse() 


后期补充...


