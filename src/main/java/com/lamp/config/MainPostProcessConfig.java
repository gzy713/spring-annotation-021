package com.lamp.config;

import com.lamp.bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainPostProcessConfig {
    @Bean
    public MyBeanPostProcessor MyBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
