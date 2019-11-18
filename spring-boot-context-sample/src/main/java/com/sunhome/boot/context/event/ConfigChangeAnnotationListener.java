package com.sunhome.boot.context.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wangqijia
 * @date 2019/11/18 19:06
 */
@Component
public class ConfigChangeAnnotationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigChangeAnnotationListener.class);


    @Async
    @EventListener(classes = ConfigChangeEvent.class)
    void onConfigChangeEvent(ConfigChangeEvent event) {
        System.out.println(" @EventListener 声明");
        event.getConfigChangeInfo().forEach((key, value) -> {
            LOGGER.info("key:{}  value:{}\n", key, value);
        });
    }
}
