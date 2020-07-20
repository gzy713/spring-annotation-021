package com.lamp.config;


import com.lamp.bean.Persion;
import org.junit.runner.manipulation.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(value = "com.lamp" ,includeFilters = {},excludeFilters = {})
@ComponentScan(value = "com.lamp", excludeFilters = {
//        根据注解排除 标了controller与service的通通排除
        @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})})

public class MainConfig {

    /*
     * id 默认用的是方法名  values可以指定值
     * clsss 用的是返回值
     *
     * */
    @Bean(value = {"perison"})
    public Persion persion() {
        return new Persion("大哥", 30);
    }
}
