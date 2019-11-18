package com.sunhome.boot.configuration.config;


import com.sunhome.boot.configuration.config.properties.EnvironmentProperties;
import com.sunhome.boot.configuration.config.properties.SunHomeProperties;
import com.sunhome.boot.configuration.config.properties.ValueProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangqijia
 * @date 2019/11/8 14:20
 */
@Configuration
public class WebConfig {

    @Bean
    public SunHomeProperties sunHomeProperties() {
        return new SunHomeProperties();
    }

    @Bean
    public ValueProperties valueProperties() {
        return new ValueProperties();
    }

    @Bean
    public EnvironmentProperties environmentProperties() {
        return new EnvironmentProperties();
    }

    /**
     * 方法参数注入
     * @param environmentProperties 注入对象
     */
    @Bean
    public String test(EnvironmentProperties environmentProperties) {
        return environmentProperties.getName();
    }


}
