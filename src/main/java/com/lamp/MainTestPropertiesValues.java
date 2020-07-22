package com.lamp;

import com.lamp.bean.Persion;
import com.lamp.config.MainConfigPropertiesValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class MainTestPropertiesValues {
    /**
     * 为属性赋值的几种方式
     * 在xml中 使用 <property  name   values></property> 的方式为属性赋值
     * 现在使用@values()的方式为属性赋值
     */

    @Test
    public void TestPropertyValues() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigPropertiesValue.class);
        String[] beans = ioc.getBeanDefinitionNames();
        for (int i = 0; i < beans.length; i++) {
            System.out.println(beans[i]);
        }

        Persion persion = (Persion) ioc.getBean("persion");
        System.out.println(persion);

/*
从环境变量中拿到配置文件中的值
* */
        Environment env = ioc.getEnvironment();
        String nickName = env.getProperty("nickName");
        System.out.println(nickName);
    }
}
