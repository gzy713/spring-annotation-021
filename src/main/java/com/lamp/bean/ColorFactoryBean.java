package com.lamp.bean;

import org.springframework.beans.factory.FactoryBean;

/*
* 创建一个spring自定义的工厂bean
* */
public class ColorFactoryBean  implements FactoryBean<ColorFactory> {

    public ColorFactory getObject() throws Exception {

        return new ColorFactory();
    }

    public Class<?> getObjectType() {
        return ColorFactory.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
