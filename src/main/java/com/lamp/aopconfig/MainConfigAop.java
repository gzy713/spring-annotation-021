package com.lamp.aopconfig;


import com.lamp.aop.LogAspects;
import com.lamp.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 *面向切面编程        好处 降低耦合性
 *          aop的原理      aop的原理是 动态代码   ioc的原理是反射
 *          第一步导入   aspects包    spring-aspects-4.3.12.RELEASE.jar   aspectjweaver-1.8.9.jar
 *           定义一个业务逻辑类MathCalculator   在业务逻辑运行之前   方法结束  方法出现异常等位子 打印日志
 *           定义一个切面类 完成辅助功能
 *                  通知方式有
 *                          前置通知(@Before):在切入点之前进行
 *                          后置通知(@after):在切入点之后进行
 *                          返回通知(@afterReturing):在方法正常返回时 执行
 *                          异常通知(@afterThrows):在方法报错时进行通知
 *                          环绕通知(@Returning):动态代理,手动通知目标方法的执行 joinPoint.proceed()
 *           给切面类标注方法何时执行
 *           一定要开启 给予注解的aop模式  @enableAspectsjAutoProxy   注解的动态代理
 *
 *     步骤  1 目标类 和切面类
 *          2 在切面类上标明  切入点 以及切面表达式
 *          3,将切面类和目标类 都加入到容器中  然后将主配置类加上 @EnableAspectAutoProxy  开启自动代理的aop配置
 *     AOP原理(  给容器中导入了什么组件 以及这个组件的功能  )
 *            @EnableAspectJAutoProxy
 *              @Import(AspectJAutoProxyRegistrar.class)  给容器中导入一个注册类
 *                      AspectJAutoProxyRegistrar  给容器导入一些组件
 *            internalAutoProxyCreator (组件) = AnnotationAwareAspectJAutoProxyCreator (类型)  给容器中注入一个组件
 *            SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware   后置处理器 就是在对象 初始化前后要做的事情
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigAop {

    @Bean
    public MathCalculator MathCalculator(){
      return    new MathCalculator();
    }

    @Bean
    public LogAspects LogAspects(){
        return    new LogAspects();
    }
}
