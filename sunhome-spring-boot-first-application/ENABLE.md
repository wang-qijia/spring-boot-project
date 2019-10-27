# @Enable模块驱动

## 接口编程
    * import 导入ConfigurationClass将其注册为spring bean
    * ImportSelector 返回类的全路径名称数组
    * ImportBeanDefinitioREGISTRAR 比ImportSelector多了将bean注册到容器当中一步

## 源码解析
ConfigurationClassParser

