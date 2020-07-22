package com.lamp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 *
 * 此注解 只是标识是一个 切面类 但是并没有加入到容器中
 *  public void logStart(JoinPoint JoinPoint) {  必须出现在 参数的首位 否者 spring是无法识别的
 */
@Aspect
public class LogAspects {


    //抽取公共的切入点表达式
    //本类的引用
    @Pointcut("execution(public int com.lamp.aop.MathCalculator.*(..) )")
    public void pointCut() {

    }

    /*方法不限  参数个数 一个点 代表一个参数
     * 另一种写法   public int com.lamp.aop.MathCalculator.*(..)
     * */
//    @Before("public int com.lamp.aop.MathCalculator.div(int i,int j) ")  用公共的切入点表达式代替
    //本类直接写 方法名()    外部类 带上全路径
    @Before("pointCut()")
    public void logStart(JoinPoint JoinPoint) {
        String name = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();
        System.out.println("除法运行了"+"方法名字"+ name+"参数"+ Arrays.toString(args) );
    }


    @After("com.lamp.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint JoinPoint) {
        String name = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();

        System.out.println("除法结束了"+name+"参数"+ Arrays.toString(args) );
    }

    /**
     *  "result")  接收结果值的站位
     *
     * @param JoinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()" ,returning = "result")
    public void logReturning(JoinPoint JoinPoint,Object result) {
        String name = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();


        System.out.println("除法正常返回"+ "方法名字"+ name+"参数"+ Arrays.toString(args) +"结果值"+result);
    }

    /*
    * 接收异常信息的站位
    * */

    @AfterThrowing(value = "pointCut()" ,throwing = "e")
    public void logException(JoinPoint JoinPoint ,Exception e) {
        String name = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();


        System.out.println("除法有异常了"+name+"参数"+ Arrays.toString(args)+e );
    }
}
