package com.sunhome.boot.autoconfigure;

import com.sunhome.boot.config.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(TestConfiguration.class)
public class TestAutoConfiguration {
}
