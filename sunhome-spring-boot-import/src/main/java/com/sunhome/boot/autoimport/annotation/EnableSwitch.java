package com.sunhome.boot.autoimport.annotation;


import com.sunhome.boot.autoimport.configuration.SwitchImportBeanDefinitionRegistrar;
import com.sunhome.boot.autoimport.service.FileService;
import com.sunhome.boot.autoimport.service.impl.LocalFileServiceImpl;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(SwitchImportSelector.class)
@Import(SwitchImportBeanDefinitionRegistrar.class)
public @interface EnableSwitch {

    Class<? extends FileService> fileClass() default LocalFileServiceImpl.class;

}
