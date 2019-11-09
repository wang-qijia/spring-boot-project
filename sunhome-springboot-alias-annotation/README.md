# spring-boot @AliasFor使用

## 注解模式类型
* 元注解 @Component (ContextNamespaceHandler 处理器)
* 模式注解 @Component派生注解 @Service @Controller
* 组合注解 @SpringBootApplication


## spring专有注解属性别名和覆盖
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

## 常见问题
@AliasFor在不同注解中不可单向覆盖@Component中的value属性，
原因是这些value特性的特殊处理在@AliasFor发明的数年前就已经存在，为了向后兼容问题不可能使用@AliasFor 在value这些属性


## 源码剖析
AnnotationAttributes.getMergedAnnotationAttributes()
指定element的元注解层次中查到第一个类型名为annotationName的注解，将它底层的元注解合并到当前AnnotationAttributes之中


后期补充...


