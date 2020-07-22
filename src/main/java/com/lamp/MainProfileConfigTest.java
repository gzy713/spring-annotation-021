package com.lamp;

import com.lamp.config.MainProfileConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;

/**
 *
 * *  1,第一种切换方式 在虚拟机参数中加入  -Dspring.profiles.active=test
 * 2写无参构造器
 *
 */
public class MainProfileConfigTest {

    @Test
    public void testDatesource() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        ioc.getEnvironment().setActiveProfiles("dev");
        ioc.register(MainProfileConfig.class);
        ioc.refresh();
        String[] datasources = ioc.getBeanNamesForType(DataSource.class);
        for (int i = 0; i < datasources.length; i++) {
            System.out.println("数据源是"+datasources[i]);
        }

    }

    @Test
    public void testProfile() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainProfileConfig.class);

        ComboPooledDataSource DataSource = (ComboPooledDataSource) ioc.getBean("test");
        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select *  from employee ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString("lastName");
                System.out.println(string);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    @Test
    public void testProfileDriverManagerDataSource() {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainProfileConfig.class);

        DriverManagerDataSource DataSource = (DriverManagerDataSource) ioc.getBean("dev");
        try {
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select *  from employee ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString("lastName");
                System.out.println(string);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
