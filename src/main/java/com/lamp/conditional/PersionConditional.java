package com.lamp.conditional;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PersionConditional implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        /*
         * 获取环境信息
         * */
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");


        /*获取bean定义的注册类*/
        BeanDefinitionRegistry registry = context.getRegistry();

        if (property!=null&&property.toLowerCase().contains("win")){
//            registry.removeBeanDefinition("jacksonid");
            return true;
        }else{
//            registry.removeBeanDefinition("eastwoodid");
            return  false;
        }
//        registry.getBeanDefinition("")

     //   String[] beanDefinitionNames = registry.getBeanDefinitionNames();
    //    System.out.println(beanDefinitionNames);

        /*
        * 获取资源
        * */
      //  ResourceLoader resourceLoader = context.getResourceLoader();

        /*
        * 获取类加载器
        * */
     //   ClassLoader classLoader = context.getClassLoader();

     //   ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();


     //   return false;
    }
}
