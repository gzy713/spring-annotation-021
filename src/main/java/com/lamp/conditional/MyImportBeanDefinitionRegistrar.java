package com.lamp.conditional;

import com.lamp.bean.YelloGren;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /*
    * importingClassMetadata  标注 @import的注解信息
    * registry         BeanDefinitionRegistry定义的注册类
    * 通过registry对象 把组件注册进来
    *
    * */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
      /*注意要小写*/
        boolean yellow1 = registry.containsBeanDefinition("com.lamp.bean.Color");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(YelloGren.class);
        if(yellow1)
        registry.registerBeanDefinition("com.lamp.bean.YelloGren",rootBeanDefinition);
    }
}
