package com.sunhome.boot.alias.util;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class AnnotatedUtils {

    public void print(AnnotatedElement annotatedElement, Class<? extends Annotation> annotationType) {
        AnnotationAttributes serviceAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, annotationType);
        System.out.println("注解名称:" + serviceAttributes.annotationType().getName());
        serviceAttributes.forEach((name, value) -> {
            System.out.printf("属性%s:%s\n", name, value);
        });

    }
}
