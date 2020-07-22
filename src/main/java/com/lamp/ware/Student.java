package com.lamp.ware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/*
*
* 目的用到一些底层的ioc组件
* */


@Component
class Student implements ApplicationContextAware, BeanNameAware , EmbeddedValueResolverAware {

    //    ioc容器就会被自动传入
    public void setApplicationContext(ApplicationContext ioc) throws BeansException {
        String[] beans = ioc.getBeanDefinitionNames();
        for (int i = 0; i < beans.length; i++) {
            System.out.println(beans[i]);
        }

    }

    //自动注入的
    public void setBeanName(String name) {
        System.out.println("存放到ioc容器中的名字是" + name);
    }

    //自动注入的
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        /*
        * ${} 在配置文件中是取properties中的值    但是最终 properties的值会被放到环境变量中
        * */
        String s = resolver.resolveStringValue("你好${os.name}" + "#{40+5}");
        System.out.println(s);
    }
}
