package com.sunhome.boot.context.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @author wangqijia
 * @date 2019/11/18 13:28
 */
public class ConfigChangeEvent extends ApplicationEvent {

    public ConfigChangeEvent(Map<String, Object> source) {
        super(source);
    }

    public Map<String, Object> getConfigChangeInfo() {
        return (Map) getSource();
    }

}
