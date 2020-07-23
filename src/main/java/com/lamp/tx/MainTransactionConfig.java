package com.lamp.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
 * 声明式事务
 *       1),导入相关依赖  spring-jdbc  用spring提供的模板类  template 来操作数据库
 *       2), 给方法加上 @transactional
 *        3), 给主配置类加上       @EnableTransactionManagement
 *         4)  注册事务管理器
 * */

@Configuration
@ComponentScan("com.lamp.tx")
@EnableTransactionManagement
public class MainTransactionConfig {

    @Bean
    public DataSource DataSource() {
//        ComboPooledDataSource
        ComboPooledDataSource datasouces = new ComboPooledDataSource();
       // datasouces.setJdbcUrl("jdbc:mysql://192.168.241.129:3306/jpa?characterEncoding=utf8");
        datasouces.setJdbcUrl("jdbc:mysql://192.168.241.129:3306/jpa");
        datasouces.setUser("root");
        datasouces.setPassword("123456");
        try {
            datasouces.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return datasouces;

    }

    //      在配置类中方法中的值 可以直接从容器中取
    //spring 对configuration  有特殊处理
    @Bean
    public JdbcTemplate JdbcTemplate(DataSource DataSource) {
        return new JdbcTemplate(DataSource);
    }
    
    
    @Bean
    public PlatformTransactionManager  PlatformTransactionManager(DataSource DataSource){

        return new DataSourceTransactionManager(DataSource);
    }
}
