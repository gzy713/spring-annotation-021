package com.lamp;

import com.lamp.bean.YelloGren;
import com.lamp.config.MainAutowiredConfig;
import com.lamp.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAutowiredTest {



    @Test
    public void testAutowired() {


        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainAutowiredConfig.class);


        String[] beans = ioc.getBeanDefinitionNames();
        for (int i = 0; i < beans.length; i++) {
  //System.out.println(beans[i]);
        }
        BookService bookService1 = (BookService) ioc.getBean(BookService.class);
        System.out.println(bookService1);

        BookService bookService = (BookService) ioc.getBean("bookService");
        bookService.display();



    }
}
