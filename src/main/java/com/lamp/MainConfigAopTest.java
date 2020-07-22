package com.lamp;

import com.lamp.aop.MathCalculator;
import com.lamp.aopconfig.MainConfigAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigAopTest {
    @Test
    public void Test() {

        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathCalculator mathCalculator = (MathCalculator) ioc.getBean("MathCalculator");
        int div = mathCalculator.div(4, 2);
        System.out.println("result="+div);

    }
}
