package com.sunhome.boot.autoimport.configuration;


import com.sunhome.boot.autoimport.annotation.EnableSwitch;
import com.sunhome.boot.autoimport.service.FileService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class SwitchImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableSwitch.class.getName());

        Class<? extends FileService> fileClass=(Class)annotationAttributes.get("fileClass");
        fileClass.getName();
        return new String[]{fileClass.getName()};
    }
}
