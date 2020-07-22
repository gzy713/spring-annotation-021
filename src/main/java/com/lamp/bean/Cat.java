package com.lamp.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements DisposableBean , InitializingBean {

    public Cat() {
        System.out.println(Cat.class+"对象的构造");
    }

    public void destroy() throws Exception {
        System.out.println(Cat.class+"销毁");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(Cat.class+"初始化");
    }
}
