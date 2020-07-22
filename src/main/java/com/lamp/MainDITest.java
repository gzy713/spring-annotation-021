package com.lamp;

import com.lamp.bean.Persion;
import com.lamp.bean.YelloGren;
import com.lamp.bean.Yellow;
import com.lamp.config.MainBeanLifeCycle;
import com.lamp.config.MainConfig;
import com.lamp.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.*;

public class MainDITest {

    /**
     * 配置文件的方式
     */

    @Test
    public void testBeanXml() {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Object persion = ioc.getBean("persion");
        System.out.println(persion);


    }

    @Test
    public void beansSaneid() {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("beansSaneid.xml");


    }


    /**
     * 注解的方式
     */
    @Test
    public void testAnnotationConfigClass() {

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
    public void testCountBean() {

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
        System.out.println("---------------------------");
        for (int i = 0; i < beanNames.length; i++) {
            System.out.println(beanNames[i]);
        }

    }


    @Test
    public void mainConfig2() {

        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*
         * 无论获取多少次 由于是单实例的 所以都是同一个对象
         * */


        Object persion = ioc.getBean("persion");
        Object persion2 = ioc.getBean("persion");
//        System.out.println(persion==persion2);
        String[] beansName = ioc.getBeanNamesForType(Persion.class);
        String[] beanName = ioc.getBeanDefinitionNames();
        for (int i = 0; i < beanName.length; i++) {
            System.out.println(beanName[i]);

        }


    }

    @Test
    public void testConditional() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);
        Environment environment = ioc.getEnvironment();
        String property = environment.getProperty("os.name");


        /*
         * 查看有几个Persion的人
         * */
        String[] beanNamesForType = ioc.getBeanNamesForType(Persion.class);

        for (int i = 0; i < beanNamesForType.length; i++) {
            //       System.out.println(beanNamesForType[i]);
        }

        Map<String, Persion> beansOfType = ioc.getBeansOfType(Persion.class);
        System.out.println(beansOfType);
//        Iterator<Map.Entry<String, Persion>> iterator = beansOfType.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Persion> next = iterator.next();
//            String key = next.getKey();
//          Persion value = next.getValue();
//
//            System.out.println(key+"-------------"+value);
//        }
//
//        Object bean = ioc.getBean("jackson");
//        System.out.println(bean);

    }

    /*
     * @import  导入组件到容器中  主要导入别人写好的jar包之类的
     * 只需要在配置类上加入 @import (Color.class)
     * */
    @Test
    public void testImport() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*注意通过  @import 导入的想要获取 要通过字节码对象*/
        Object yello = ioc.getBean(Yellow.class);
        System.out.println(yello);

        Object YelloGren = ioc.getBean(YelloGren.class);
        System.out.println(YelloGren);

        Object colorFactoryBean = ioc.getBean("colorFactoryBean");
        /**
         * class com.lamp.bean.ColorFactory
         */
        System.out.println(colorFactoryBean.getClass());

        Object colorFactory = ioc.getBean("&colorFactoryBean");
        System.out.println(colorFactory);


        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }

    @Test
    public void testBeanLifeCycle() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainBeanLifeCycle.class);
        String[] beans = ioc.getBeanDefinitionNames();
        for (int i = 0; i < beans.length; i++) {
            System.out.println(beans[i]);
        }
//        ioc=null;
        /**/
        ioc.close();
    }
}
