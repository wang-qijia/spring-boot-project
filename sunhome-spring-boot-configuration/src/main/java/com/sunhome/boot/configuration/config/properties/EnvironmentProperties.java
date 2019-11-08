package com.sunhome.boot.configuration.config.properties;

import lombok.Data;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author wangqijia
 * @date 2019/11/8 15:23
 */
@Data
public class EnvironmentProperties implements EnvironmentAware {

    private Environment environment;

    private String name;


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.name = environment.getProperty("environment.name");
    }


}
