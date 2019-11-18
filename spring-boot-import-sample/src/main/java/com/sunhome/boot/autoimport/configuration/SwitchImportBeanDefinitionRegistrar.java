package com.sunhome.boot.autoimport.configuration;


import com.sunhome.boot.autoimport.annotation.EnableSwitch;
import com.sunhome.boot.autoimport.service.FileService;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.stream.Stream;

public class SwitchImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        String[] selectImports = this.selectImports(annotationMetadata);

        Stream.of(selectImports)
                .map(importClass -> {
                    return BeanDefinitionBuilder.genericBeanDefinition(importClass);
                }).map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> {
                    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, beanDefinitionRegistry);
                });
    }

    private String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableSwitch.class.getName());

        Class<? extends FileService> fileClass = (Class) annotationAttributes.get("fileClass");
        fileClass.getName();
        return new String[]{fileClass.getName()};
    }
}
