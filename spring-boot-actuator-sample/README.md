# spring-boot 监控模块

## 生产监控组件
* spring boot actuator作用   
    * 健康检查
    * 应用监控
    * 指标收集
* 默认端口
    * /actuator/health
     * /actuator/env
     
## 整合 prometheus

```xml
        <!--监控门面框架-->
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
        </dependency>
```
## prometheus下载地址
1. [Prometheus 2.4.3 for Windows](https://github.com/prometheus/prometheus/releases/download/v2.4.3/prometheus-2.4.3.windows-amd64.tar.gz)
2. [Grafana 5.3.2 for Windows](https://s3-us-west-2.amazonaws.com/grafana-releases/release/grafana-5.3.2.windows-amd64.zip)
3. [Alertmanager 0.15.2 for Windows](https://github.com/prometheus/alertmanager/releases/download/v0.15.2/alertmanager-0.15.2.windows-amd64.tar.gz)

## 参考文章
[https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)

后续补充....




    

