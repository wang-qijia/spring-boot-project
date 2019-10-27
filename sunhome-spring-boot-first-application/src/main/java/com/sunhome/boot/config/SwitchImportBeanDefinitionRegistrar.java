package com.sunhome.boot.config;

import com.sunhome.boot.annotation.EnableSwitch;
import com.sunhome.boot.enums.SwitchEnum;
import com.sunhome.boot.service.impl.LocalFileServiceImpl;
import com.sunhome.boot.service.impl.RemoteFileServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
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
        boolean open = (boolean) annotationAttributes.get(EnableSwitch.BOOLEAN_OPEN);

        String[] importClassNames = new String[0];

        if (open == SwitchEnum.OPEN.isOpen()) {
            importClassNames = new String[]{RemoteFileServiceImpl.class.getName()};
        } else {
            importClassNames = new String[]{LocalFileServiceImpl.class.getName()};

        }
        return importClassNames;
    }
}
