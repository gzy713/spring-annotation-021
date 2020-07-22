package com.lamp.config;

import com.lamp.bean.YelloGren;
import com.lamp.dao.BookDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 *
 * 自动装配
 * spring通过 依赖注入(DI)完成对容器中 各个组件属性的注入  通过 boolcontroller   bookservice  bookDao完成对属性的自动装配
 *
 * @autowired  自动装配
 *         BookService {
 *                          @autowired
 *                          BookDao   bookDao
 *         }
 *          原理是    首先按照类型去找ioc.getBean("BookService.class")  如果找到多个
 *                     在按照    属性的name去找  bookDao   精确匹配
 *               @ controller service  respository  component  标注在类上  组件id为类的首字母小写
 *           如果容器中有多个相同的组件类型 可以使用 qualifier("主键id")  指定装配哪一个
 *
 *                  @Qualifier("BookDao")
                    @Autowired(required = "false")  如果组件中找不到也不会报错
                    BookDao BookDao;
             在放入组件的时候指定 @primary  那么如果属性上没有指定qualifer时  时首先指定 @primary下的组件的
 *
 * @Resource 在JSR250规范中提到的   @Inject JSR330中提到的   java规范的注解
 *                      @Resource默认按照属性名称进行装配  相当于 @autowire的 第二步
 *                      @Resource(name="组件id")  也可以通过指定组件id进行转配
 *                                    !!! 不支持primary  和 autowired(require=false)
 *                      @Inject  需要导入 Inject包 和autoWired的功能一样
 *      自动转配 原理AutowiredAnnotationBeanPostProcessor 完成自动装配的  后置处理器
 *
 *  @autowired  标注的位置   属性 构造器 方法   参数
 *              标注在set方法上(或者set 方法中的参数上)  ioc容器创建完对象 就会调用此方法  完成方法的参数赋值  方法使用的参数  自定义类型的值从ioc容器中获取
 *                               !!!默认加在ioc容器中的组件 在容器启动的时候会默认调用无参构造器 完成对应的初始化 然后再进行赋值
 *              标注在构造器上(或者构造器的方法的参数上 )     有参构造器  容器启动 调用有参构造器完成属性的赋值
 *                                  !!!标注在构造器上 如果只有一个有参构造器 那么autowired可以进行省略
 *
 *                 @Bean(value = {"perison"})
                    public Persion persion( Object  obj  ) {  参数中的值也是从ioc容器中获取
                        return new Persion("大哥", 30);
                    }
 *     自定义组件 要想使用一些spring底层的一些组件(applicationContext,beanfactory ,XXX)
*         !!!只需要自定义组件实现 XXXXware即可   在调用对象的时候   会注入相关组件
*         XXXXware=XXXXprocessor  想对应    XXXXprocessor 通过后置处理器传入对应的值 通过set方法
 *
 *
 *
 **/
@Configuration
@ComponentScan(value = {"com.lamp.dao", "com.lamp.service", "com.lamp.controller"})
public class MainAutowiredConfig {
//    @Bean
//    public YelloGren YelloGren() {
//        return new  YelloGren();
//    }
//
//    @Bean
//    public YelloGren yelloGren() {
//        return new YelloGren();
//    }


//    @Bean
//    public BookDao bookDao(){
//        return  new BookDao();
//    }

}


