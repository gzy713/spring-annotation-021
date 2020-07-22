package com.lamp.bean;

import org.springframework.beans.factory.annotation.Value;

public class Persion {

    /**
     *
     *
     * 为属性赋值的几种方式
     * 在xml中 使用 <property  name   values></property> 的方式为属性赋值
     * 现在使用@values()的方式为属性赋值
     * 1,可以写基本的字符串
     * 2,可以写 spel表达式 #{}  简称el表达式
     * 3,获取properties中的值  在主类上添加  @PropertySource(value = {"classpath:/persion.properties"})
     */






    @Value("张三")
    String name;
//    el表达式
    @Value("#{1+3}")
    Integer age;
//    在主类上添加  @PropertySource(value = {"classpath:/persion.properties"})
    @Value("${nickName}")
    String nickName;

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Persion() {

    }

    public Persion(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
