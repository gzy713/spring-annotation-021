package com.lamp.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate JdbcTemplate;

    public  void  insert(){
        String str="INSERT  into tab_user values(?,?,?) ";
        //JdbcTemplate.execute(str,"小明","124@qq.com");
        int i = JdbcTemplate.update(str, 2,"tom", "1261493758@qq.com");
        System.out.println(i);
    }
}
