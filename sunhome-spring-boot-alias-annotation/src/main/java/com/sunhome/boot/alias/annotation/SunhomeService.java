package com.sunhome.boot.alias.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface SunhomeService {

    String value() default "sunhome";
}
