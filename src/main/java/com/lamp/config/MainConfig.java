package com.lamp.config;


import com.lamp.bean.Persion;
import com.lamp.dao.BookDao;
import org.junit.runner.manipulation.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
//@ComponentScan(value = "com.lamp" ,includeFilters = {},excludeFilters = {})
@ComponentScan(value = "com.lamp", includeFilters = {
//        根据注解排除 标了controller与service的通通排除
        /*useDefaultFilters = false
        * 关闭意味着一个都不扫描
        * type = FilterType.ANNOTATION 按照注解 进行过滤
        * ANNOTATION
        * ASSIGNABLE_TYPE
        * ASPECTJ
        * REGEX
        * CUSTOM  @link org.springframework.core.type.filter.TypeFilter} implementation.  必须是一个实现类
        * */
//        @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDao.class})},
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})},
        useDefaultFilters = false)



public class MainConfig {

    /*
     * id 默认用的是方法名  values可以指定值
     * clsss 用的是返回值
     *
     * */
    @Bean(value = {"perison"})
    public Persion persion() {
        return new Persion("大哥", 30);
    }
}
