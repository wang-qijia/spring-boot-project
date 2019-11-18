package com.sunhome.boot.context.controller;

import com.sunhome.boot.context.event.ConfigChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqijia
 * @date 2019/11/18 13:52
 */
@RestController
public class EventController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/config/publish")
    public String publish() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put("name", "lisha");
        configMap.put("age", "18");
        eventPublisher.publishEvent(new ConfigChangeEvent(configMap));
        System.out.println("publish end");
        return "ok";
    }

}
