package com.sunhome.boot.enable.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.Set;

public class DefaultAutoConfigurationImportListener implements AutoConfigurationImportListener {


    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {

        ClassLoader classLoader = event.getClass().getClassLoader();

        List<String> candidates = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, classLoader);


        List<String> candidateConfigurations = event.getCandidateConfigurations();

        Set<String> exclusions = event.getExclusions();

        System.out.printf("自动装配class名单-候选数量:%d,实际数量:%d,排除数量:%d\n", candidates.size(), candidateConfigurations.size(), exclusions.size());


    }
}
