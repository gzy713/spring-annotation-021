package com.lamp;

import com.lamp.config.MainWareConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*
*
*
* */
public class MainWareTest {
    @Test
    public  void  testWare(){

        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainWareConfig.class);
    }
}
