package com.sunhome.boot.configuration.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author wangqijia
 * @date 2019/11/8 14:15
 */
@Data
public class ValueProperties {

    @Value("${value.name}")
    private String name;
}
