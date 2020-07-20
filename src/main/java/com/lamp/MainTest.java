package com.lamp;

import com.lamp.bean.Persion;
import com.lamp.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainTest {

    /**
     *
     * 配置文件的方式
     *
     */

    @Test
    public void testBeanXml() {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Object persion = ioc.getBean("persion");
        System.out.println(persion);


    }

    /**
     *
     * 注解的方式
     */
    @Test
    public  void  testAnnotationConfigClass(){

        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
       // Object persion = ioc.getBean("persion");
        //System.out.println(persion);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        String s = Arrays.toString(beanDefinitionNames);
        System.out.println(s);
        String[] beanNamesForType = ioc.getBeanNamesForType(Persion.class);
        String ty = Arrays.toString(beanNamesForType);
        System.out.println(ty);
    }
    @Test
    public  void testCountBean(){

        /*
        * bookController
            bookDao
            bookService
            *
            * 结论 之前 要用 @ controller service  respository  component    要下 <context：component-scan>
            * 现在 只需要在  主配置类中写 @componentScan
            *
        *
        * */

       ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = ioc.getBeanDefinitionNames();
        for (int i = 0; i <beanNames.length ; i++) {
            System.out.println(beanNames[i]);
        }
        System.out.println("已修改");
    }
}
