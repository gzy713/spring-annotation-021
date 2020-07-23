package com.lamp.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTx {

    
    @Test
    public  void  insertTx(){

        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainTransactionConfig.class);
        UserService bean = (UserService) ioc.getBean("userService");
        bean.insert();

    }
    
}
