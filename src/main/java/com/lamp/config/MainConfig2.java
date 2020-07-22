package com.lamp.config;

import com.lamp.bean.Color;
import com.lamp.bean.ColorFactoryBean;
import com.lamp.bean.Persion;
import com.lamp.bean.Red;
import com.lamp.conditional.MyImportBeanDefinitionRegistrar;
import com.lamp.conditional.MyImportSelector;
import com.lamp.conditional.PersionConditional;
import com.oracle.webservices.internal.api.message.PropertySet;
import org.springframework.context.annotation.*;

@Configuration
/*
* 将组件导入到容器中
* */
@Import({Red.class,Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    /*
    *
    * 将id =perison  class =Persion
    *
    *     String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    *
    *
    *
	 * Specifies the name of the scope to use for the annotated component/bean.
	 * <p>Defaults to an empty string ({@code ""}) which implies
	 * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
	 * @since 4.2
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST   request  同一个请求创建一个对象
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION         session  同一个session创建一个对象
	 * @see #value

	 *    String SCOPE_SINGLETON = "singleton";  单实例环境
      String SCOPE_PROTOTYPE = "prototype";     多实例环境
      *
      *  当时singleton的时候 ioc容器启动的时候 就会实例化
      * 当时 prototype的时候是getbean的时候实例化的
      *
      *
      * 懒加载(懒加载对应的是单实例的bean)
      *     容器启动的时候不加载对象   第一次调用的时候再加载对象  并且进行初始化
      *
      *
      * */
    @Lazy
    @Scope("singleton")
    @Bean("persion")
    public Persion persion() {
        System.out.println("persion实例化");
        return new Persion("郭志远", 20);
    }


    /*
     *@Target({ElementType.TYPE, ElementType.METHOD})  type  是类上  method是方法上
     * conditonal  条件注入  只有满足一定条件才给容器进行注入 否者不进行注入
     * -Dos.name=linux  修改虚拟机名字
     *
     *  @Conditional({ PersionConditional.class})  写在类上 表示满足当前条件下 这个类下的组件才生效
     * */

    @Bean("jacksonid")
    @Conditional({ PersionConditional.class})
    public Persion Persion() {
        return new Persion(" jackson", 50);
    }



    @Conditional({ PersionConditional.class})
    @Bean("eastwoodid")
    public Persion Persion1() {
        return new Persion(" eastwood", 50);
    }


    /**
     *
     * 虽然往容器中注册的是  ColorFactoryBean  实际上是 他方法中的new 对象
     * @return
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new   ColorFactoryBean();
    }

}
