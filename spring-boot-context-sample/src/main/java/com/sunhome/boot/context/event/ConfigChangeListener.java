package com.sunhome.boot.context.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangqijia
 * @date 2019/11/18 13:42
 */
@Component
public class ConfigChangeListener implements ApplicationListener<ConfigChangeEvent> {

    @Override
    public void onApplicationEvent(ConfigChangeEvent event) {
        System.out.println(" impl ApplicationListener 声明");

        Map<String, Object> configChangeInfo = event.getConfigChangeInfo();
        configChangeInfo.forEach((key, value) -> {
            System.out.printf("key:%s  value:%s\n", key, value);
        });
    }

    @EventListener(value = ConfigChangeEvent.class)
    void onConfigChangeEvent(ConfigChangeEvent event) {
        System.out.println(" @EventListener 声明");
        Map<String, Object> configChangeInfo = event.getConfigChangeInfo();
        configChangeInfo.forEach((key, value) -> {
            System.out.printf("key:%s  value:%s\n", key, value);
        });
    }
}
