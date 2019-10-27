package com.sunhome.boot.annotation;

import com.sunhome.boot.config.HelloWorldConfiguration;
import com.sunhome.boot.config.SwitchImportBeanDefinitionRegistrar;
import com.sunhome.boot.config.SwitchImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(SwitchImportSelector.class)
@Import(SwitchImportBeanDefinitionRegistrar.class)
public @interface EnableSwitch {

    public static final String BOOLEAN_OPEN = "open";

    boolean open() default false;
}
