package com.lamp.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import java.beans.PropertyVetoException;

/**
 * profile  配置文件
 * <p>
 * Spring根据当前环境,动态的切换一系列组件的功能
 * 比如项目上线 有开发环境  测试环境  生产环境
 * 以数据源为例   不同环境用不同的开发环境
 *  @Profile("default")  默认标识 default的组件才会加载到ioc容器中
 *  1,第一种切换方式 在虚拟机参数中加入  -Dspring.profiles.active=test
 *  2,在容器启动之前写代码
 *  @Profile写在类上 表示只有在这个类上  才生效
 *没有指定标识的bean都会加入到ioc容器中
 *
 */
@PropertySource("classpath:/dbconnnect.properties")
@Configuration
public class MainProfileConfig implements EmbeddedValueResolverAware {
    /*
     * 从配置文件中取值
     * */
    @Value("${user}")
    String user;

    StringValueResolver resolver;

    @Profile("test")
    @Bean(value = {"test"})
    public ComboPooledDataSource comboPooledDataSource(@Value("${password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://192.168.241.129:3306/spring_cache");
        dataSource.setUser(user);
        String driver = resolver.resolveStringValue("${driver}");

        dataSource.setDriverClass(driver);

        dataSource.setPassword(password);
        return dataSource;
    }

    @Profile("dev")
    @Bean(value = {"dev"})
    public DriverManagerDataSource driverManagerDataSource(@Value("${password}") String password) throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();

//
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://192.168.241.129:3306/spring_cache");
        dataSource.setUser(user);

        String driver = resolver.resolveStringValue("${driver}");

        dataSource.setDriverClass(driver);
        dataSource.setPassword(password);
        return dataSource;
    }


    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String driver = resolver.resolveStringValue("${driver}");
        System.out.println("数据库驱动为"+driver);
        this.resolver = resolver;
    }
}
