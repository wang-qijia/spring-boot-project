package com.sunhome.boot.actuator.controller;

import com.sunhome.boot.actuator.annotation.RequestRate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqijia
 * @date 2019/11/13 13:20
 */
@RestController
public class ActuatorController {

    @RequestRate(tags = {"url", "/hello"})
    @GetMapping(value = "/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "doge") String name) {
        return String.format("%s say hello!", name);
    }
}
