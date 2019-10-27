package com.sunhome.boot.config;

import com.sunhome.boot.annotation.EnableSwitch;
import com.sunhome.boot.enums.SwitchEnum;
import com.sunhome.boot.service.impl.LocalFileServiceImpl;
import com.sunhome.boot.service.impl.RemoteFileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.nio.file.OpenOption;
import java.util.Map;

public class SwitchImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableSwitch.class.getName());
        boolean open = (boolean) annotationAttributes.get(EnableSwitch.BOOLEAN_OPEN);

        String[] importClassNames = new String[0];

        if (open== SwitchEnum.OPEN.isOpen()) {
            importClassNames = new String[]{RemoteFileServiceImpl.class.getName()};
        } else {
            importClassNames = new String[]{LocalFileServiceImpl.class.getName()};

        }
        return importClassNames;
    }
}
