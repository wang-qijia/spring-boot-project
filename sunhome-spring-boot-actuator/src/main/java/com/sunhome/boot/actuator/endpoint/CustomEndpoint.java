package com.sunhome.boot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqijia
 * @date 2019/11/11 13:35
 */
@Endpoint(id="system")
public class CustomEndpoint {

    @ReadOperation
    public Map check() {
        Map<String,Object>  map = new HashMap<>();
        map.put("STATUS", "UP");
        return map;
    }
}
