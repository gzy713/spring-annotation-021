package com.lamp.config;

import com.lamp.bean.CarLifeCycle;
import com.lamp.bean.Cat;
import com.lamp.bean.dog;
import org.junit.Test;
import org.springframework.context.annotation.*;

/**
 *
 * bean  的创建-->运行-->销毁的过程
 * 1)制定bean的创建以及销毁
 *      xml  init-method="" destroy-method="">
 *      对象的创建(
 *          singleton 单例 ioc容器实例化的时候启动
 *          prototype  队里  getBean的时候启动
 *      )
 *      1,为对象制定创建和销毁的方法
 *          initMethod = "init",destroyMethod = "destory")
 *           !!!注意销毁方法是容器关闭的时候调用
 *           特殊情况
 *              单实例bean  容器创建的时候进行实例化  在容器关闭的时候进行销毁
 *              多实例bean  在getbean的时候进行初始化   容器关闭也不会进行销毁
 *       2,制定初始化和销毁方法(
 *           @bean  制定 实现  InitializingBean   的 afterPropertiesSet 实现初始化
 *           @bean  制定       DisposableBean     destroy
  *           !!!  注意 初始化怎么对单(多)实例bean  但是销毁只针对单实例bean
 *        3,JSR250规范的注解
 *              @postConstruct
 *              @predestory
 *        4, 实现此借口 BeanPostProcessor  init前
 *         实现此借口 BeanPostProcessor   init  后
 *        CarLifeCycle对象的构造
             * postProcessBeforeInitialization--->CarLifeCycle-->com.lamp.bean.CarLifeCycle@350aac89
             * CarLifeCycle对象的初始化
             * postProcessAfterInitialization--->CarLifeCycle-->com.lamp.bean.CarLifeCycle@350aac89
 *
 *          CarLifeCycle对象的构造
 * 后置处理器postProcessBeforeInitialization--->CarLifeCycle-->com.lamp.bean.CarLifeCycle@5afa3c9
 * CarLifeCycle对象的初始化
 * 后置处理器postProcessAfterInitialization--->CarLifeCycle-->com.lamp.bean.CarLifeCycle@5afa3c9
 *
 *
 */
//@Import({dog.class})
    /*@ComponentScan(value ={"com.lamp.bean"} )要配合  @component @controler  等
    * */
@ComponentScan(value ={"com.lamp.bean"} )
@Configuration
public class MainBeanLifeCycle {
    @Bean(initMethod = "init",destroyMethod = "destory")
    public CarLifeCycle CarLifeCycle(){
        return  new CarLifeCycle();
    }

    @Bean
    public Cat Cat(){
        return new Cat();
    }
    
    
    @Test
    public  void  test(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MainBeanLifeCycle.class);
    }


}
