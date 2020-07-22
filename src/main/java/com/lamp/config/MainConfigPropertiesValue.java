package com.lamp.config;

import com.lamp.bean.Persion;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * 属性的赋值
 * @PropertySource(value = {"classpath:/persion.properties"})   加载完配置文件 用@value("${}")取值
 */
@PropertySource(value = {"classpath:/persion.properties"})
@Configuration
public class MainConfigPropertiesValue {

    @Bean
    public Persion persion(){
        return  new Persion();
    }
}
