# spring-boot-prometheus

## 目的
模拟一个简单的HTTP微服务，生成Prometheus Metrics，可以Spring Boot方式运行

## 测试地址
[http://127.0.0.1:8080/actuator/prometheus](http://127.0.0.1:8080/actuator/prometheus)
## promQL书写
校验spring-boot-simulator在**1**状态
```
up{job="spring-boot-simulator"}
```

查询http请求数
```
http_requests_total{job="spring-boot-simulator"}
```

查询成功login请求数
```
http_requests_total{job="spring-boot-simulator", status="200", endpoint="/login"}
```

查询成功请求数，以endpoint区分
```
http_requests_total{job="spring-boot-simulator", status="200"}
```

查询总成功请求数
```
sum(http_requests_total{job="spring-boot-simulator", status="200"})
```

查询成功请求率，以endpoint区分
```
rate(http_requests_total{job="spring-boot-simulator", status="200"}[5m])
```

查询总成功请求率
```
sum(rate(http_requests_total{job="spring-boot-simulator", status="200"}[5m]))
```

## 参考文章

[非官方文章](https://www.bookstack.cn/read/prometheus-manual/prometheus-querying-functions.md)
[官方文章](https://prometheus.io/docs/prometheus/latest/querying/basics/)


后期补充...


