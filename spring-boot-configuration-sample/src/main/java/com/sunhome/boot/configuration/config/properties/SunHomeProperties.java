package com.sunhome.boot.configuration.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author wangqijia
 * @date 2019/11/8 10:48
 */
@Data
@ConfigurationProperties(prefix = "sunhome")
public class SunHomeProperties {

    @NestedConfigurationProperty
    private SystemProperties sys;

}
