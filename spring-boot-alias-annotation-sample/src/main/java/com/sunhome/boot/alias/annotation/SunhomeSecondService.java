package com.sunhome.boot.alias.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface SunhomeSecondService {


    @AliasFor(
            attribute = "value"
    )
    String valueOne() default "";


    @AliasFor(
            attribute = "valueOne"
    )
    String value() default "";
}
