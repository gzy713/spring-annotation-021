package com.lamp.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class dog implements ApplicationContextAware {
    //
    //使用ioc容器
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    public dog() {
        System.out.println("dog的构造");
    }

    @PostConstruct
    void init() {
        System.out.println("dog的初始化");
    }

    @PreDestroy
    void destory() {
        System.out.println("dog的销毁");
    }


}
