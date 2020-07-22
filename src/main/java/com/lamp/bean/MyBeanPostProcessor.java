package com.lamp.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器的一些玩法
 * 后置处理器postProcessBeforeInitialization--->org.springframework.context.event.internalEventListenerProcessor-->org.springframework.context.event.EventListenerMethodProcessor@1ed6388a
 * 后置处理器postProcessAfterInitialization
 *
 *
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        System.out.println("后置处理器的一些玩法");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器postProcessBeforeInitialization--->"+beanName+"-->"+bean);

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器postProcessAfterInitialization--->"+beanName+"-->"+bean);
        return bean;
    }
}
