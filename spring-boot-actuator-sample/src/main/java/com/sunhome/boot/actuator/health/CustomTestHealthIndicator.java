package com.sunhome.boot.actuator.health;


import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 自定义添加健康检查内容
 */
@Component
public class CustomTestHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        /**
         * 模仿ApplicationHealthIndicator其他实现类实现
         */
        builder.up().withDetail("system", "UP");

    }
}
